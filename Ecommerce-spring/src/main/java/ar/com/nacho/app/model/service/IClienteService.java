package ar.com.nacho.app.model.service;



import ar.com.nacho.app.model.entity.Pedido;
import ar.com.nacho.app.model.entity.Producto;


public interface IClienteService {

	public void guardarPedido(Pedido pedido);
	
	public Producto findProductoBy(Long id);
	
	
	
	
	
	
}
