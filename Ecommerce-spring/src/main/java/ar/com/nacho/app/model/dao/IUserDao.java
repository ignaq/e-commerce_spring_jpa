package ar.com.nacho.app.model.dao;

import org.springframework.data.repository.CrudRepository;

import ar.com.nacho.app.model.entity.Usuario;

public interface IUserDao extends CrudRepository<Usuario, Long> {

	
	public Usuario findByUsername(String username);
	
	
}
