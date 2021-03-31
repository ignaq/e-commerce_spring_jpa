package ar.com.nacho.app.controller;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import ar.com.nacho.app.model.dao.IUserDao;
import ar.com.nacho.app.model.entity.Cliente;
import ar.com.nacho.app.model.entity.Item;
import ar.com.nacho.app.model.entity.Pedido;
import ar.com.nacho.app.model.entity.Producto;
import ar.com.nacho.app.model.entity.Usuario;
import ar.com.nacho.app.model.service.IClienteService;
import ar.com.nacho.app.model.service.IPedidoService;


@Controller
@SessionAttributes({"pedido" , "cliente"})
public class PedidoController {

	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IPedidoService pedidoService;
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "/detalle/{id}" , method = RequestMethod.GET)
	public String verDetalleCompras(@PathVariable(value = "id") Long id,Authentication auth, Model model, RedirectAttributes flash) {
	
		
		Pedido pedido = pedidoService.fetchPedidoById(id);
		
		
		
		if(pedido == null) {
			flash.addFlashAttribute("error", "No existe el pedido");
			return "redirect:/";
		}
		
		
		if (! pedido.getCliente().getUsuario().getUsername().equals(auth.getName() )  ) {
			log.info("No tiene acceso a este detalle de compra");
			return "redirect:/";
		}
		
		
		
		model.addAttribute("pedido", pedido);
		
		return "detalle/detalle-pedido";
	}
	
	
	@RequestMapping(value = "/pedidos" ,  method = RequestMethod.GET)
	public String verCompras(Model model, Authentication auth, SessionStatus status) {
		
		Usuario usuario = userDao.findByUsername(auth.getName());

	
		Cliente cliente = pedidoService.fetchByIdWithPedidos(usuario.getId());
		
		if (cliente==null) {
			return "redirect:/";
		}
		
	
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Mis compras");
		status.setComplete(); 
		return "pedidos";
	}
	
	
	@PostMapping("/comprar")
	public String guardarPedido(Pedido pedido,
			@RequestParam(name = "item_id", required = false) Long[] itemId,
			@RequestParam(name="item_cant", required = false) Integer[] itemCant , SessionStatus status, 
			Authentication auth) {
		
		Usuario usuario = userDao.findByUsername(auth.getName());
		
		
		
		if(itemId == null || itemId.length == 0) {
			System.out.println("es null");
			return "redirect:/";
		}
	
		
		for(int i = 0; i < itemId.length; i++) {
			
			Producto producto = clienteService.findProductoBy(itemId[i]);
			
			
			Item item = new Item();
			item.setCantidad(itemCant[i]);
			item.setProducto(producto);
			pedido.addItemPedido(item);
			pedido.setCliente(usuario.getCliente());
			
			
			log.info("ID : " + itemId[i].toString() + ", CANTIDAD: " + itemCant[i].toString());
			
		}
		clienteService.guardarPedido(pedido);
		status.setComplete();
		return "redirect:/";
	} 
}
