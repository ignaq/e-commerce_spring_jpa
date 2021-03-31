package ar.com.nacho.app.model.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.nacho.app.model.dao.IClienteDao;
import ar.com.nacho.app.model.dao.IPedidoDao;
import ar.com.nacho.app.model.entity.Cliente;
import ar.com.nacho.app.model.entity.Pedido;

@Service
public class PedidoService implements IPedidoService {

	@Autowired
	private IPedidoDao pedidoDao;
	
	@Autowired
	private IClienteDao clienteDao;

	

	@Override
	public Pedido fetchPedidoById(Long id) {
		// TODO Auto-generated method stub
		return pedidoDao.fetchByIdWithClienteWithItemPedidoWithProducto(id);
	}

	@Override
	public List<Pedido> findPedidosByCliente(Long id) {
		// TODO Auto-generated method stub
		return pedidoDao.findPedidosByCliente(id);
	}

	@Override
	public Cliente fetchByIdWithPedidos(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.fetchByIdWithPedidos(id);
	}


	
	

}
