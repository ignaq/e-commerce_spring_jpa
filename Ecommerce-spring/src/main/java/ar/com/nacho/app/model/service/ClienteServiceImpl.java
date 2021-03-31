package ar.com.nacho.app.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.nacho.app.model.dao.IPedidoDao;
import ar.com.nacho.app.model.dao.IProductoDao;
import ar.com.nacho.app.model.entity.Cliente;
import ar.com.nacho.app.model.entity.Pedido;
import ar.com.nacho.app.model.entity.Producto;


@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IPedidoDao pedidoDao;
	
	@Autowired
	private IProductoDao productoDao;
	
	
	
	@Override
	@Transactional
	public void guardarPedido(Pedido pedido) {
		pedidoDao.save(pedido);
	
	}

	@Override
	public Producto findProductoBy(Long id) {
		
		return productoDao.findById(id).orElse(null);
	}

	


	
	
	
}
