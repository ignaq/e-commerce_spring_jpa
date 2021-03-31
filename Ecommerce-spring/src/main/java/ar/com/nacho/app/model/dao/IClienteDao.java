package ar.com.nacho.app.model.dao;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.com.nacho.app.model.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

	
	@Query("select c from Cliente c left join fetch c.pedidos p where c.id=?1")
	public Cliente fetchByIdWithPedidos(Long id);
	
	
	
}
