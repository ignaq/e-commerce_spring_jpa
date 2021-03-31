package ar.com.nacho.app.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.com.nacho.app.model.entity.Cliente;
import ar.com.nacho.app.model.entity.Pedido;

public interface IPedidoDao extends CrudRepository<Pedido, Long>{

	
	
	
	@Query(value = "SELECT * FROM pedidos where pedidos.cliente_id = ?1",nativeQuery = true )
	public List<Pedido> findPedidosByCliente(Long id);
	
	
	@Query("select p from Pedido p join fetch p.cliente c join fetch p.items i join fetch i.producto where p.id=?1")
	public Pedido fetchByIdWithClienteWithItemPedidoWithProducto(Long id);
	
	@Query("select c from Cliente c left join fetch c.pedidos p where c.id=?1")
	public Cliente fetchByIdWithPedidos(Long id);
	
	
}
