package ar.com.nacho.app.controller;


import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import ar.com.nacho.app.model.entity.Producto;
import ar.com.nacho.app.model.service.IProductoService;


@Controller
@SessionAttributes({"producto"})
public class ProductoController {


	
	@Autowired
	private IProductoService productoService;
	
	
	@RequestMapping(value="/crear_producto")
	public String crearProducto(Map<String, Object> model) {
		
		Producto producto = new Producto();
		model.put("producto", producto);
		model.put("titulo", "Crear producto");
		
		return "nuevo/crear_producto";
	}
	
	
	
	/* guardar producto en db*/
	@RequestMapping(value="/crear_producto", method = RequestMethod.POST)
	public String guardarProducto(Producto producto, Model model, SessionStatus status){
	
		productoService.save(producto);
		status.setComplete();
		
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value = {"/"} , method = RequestMethod.GET)
	public String listar(Model model) {

		List<Producto> prod = (List<Producto>) productoService.findAll();
		model.addAttribute("titulo", "Productos");
		model.addAttribute("productos", prod);
	
	
		
		return "index";
	} 
	
	@GetMapping(value = "/producto/{id}")
	public String ver(@PathVariable(value = "id") Long id, Map<String,Object> model ){
		
		Producto producto = productoService.findOne(id);
		if (producto==null) {
			return "redirect:/";
		}
		model.put("producto", producto);
		model.put("titulo", "Detalle: " + producto.getNombre() );
		return "producto";
	}
	
	
	@GetMapping(value = "/busqueda/{id}" , produces = {"application/json"})
	public @ResponseBody Producto addToCart(@PathVariable Long id){
	
		return productoService.findOne(id);
	
	}
	
	
/*	@GetMapping(value = "/busqueda/{id}")
	public String addToCart(@PathVariable Long id, HttpSession session, Model model){
		Producto prod = productoService.findOne(id);
		
		Item item = new Item();
		item.setProducto(prod);
		item.setCantidad(3);

		  List<Producto> list = (List<Producto>) session.getAttribute("list");

		  if(list==null){
		    list =new ArrayList<>();
		  }
	
		  
		  for (int i = 0; i < list.size(); i ++) {
		        if (list.get(i).getId() == prod.getId()) {
		        	
		        System.out.println(list.get(i).getId() + " ya existe");
		        	  list.remove(i); 
		        	  System.out.println("Eliminado");
		        }
		    }
		  list.add(prod);
		  session.setAttribute("list",list);
		  
		  // Add the name & cost to List
		 // list.add(prod);

		 // session.setAttribute("list",list);
		  System.out.println("--Productos--");
		  for (int i = 0; i < list.size(); i ++) {
		       
		        System.out.println("Producto: " + list.get(i).getId());
		       
		    }
		  
		  
		 
		
		
	//	session.setAttribute("objeto", prod);
		
	//	model.addAttribute("pedido", prod);
		
	

		return "carrito";
	} */

	
	@GetMapping(value = "/carrito")
	public String carrito(){
	
		return "carrito";
	}

	
}
