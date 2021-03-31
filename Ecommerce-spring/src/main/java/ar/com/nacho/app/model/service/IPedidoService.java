package ar.com.nacho.app.model.service;

import java.util.List;

import ar.com.nacho.app.model.entity.Cliente;
import ar.com.nacho.app.model.entity.Pedido;

public interface IPedidoService  {


	
	public Pedido fetchPedidoById(Long id);
	
	public List<Pedido> findPedidosByCliente(Long id);
	
	
	public Cliente fetchByIdWithPedidos(Long id);
}
