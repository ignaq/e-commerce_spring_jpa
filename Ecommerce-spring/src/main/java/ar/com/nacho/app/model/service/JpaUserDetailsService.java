package ar.com.nacho.app.model.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import ar.com.nacho.app.model.dao.IUserDao;
import ar.com.nacho.app.model.entity.Role;
import ar.com.nacho.app.model.entity.Usuario;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserDao userDao;
	
	private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = userDao.findByUsername(username);
		
		if(user==null) {
			logger.error("Error: no existe el usuario " + username + " ");
			throw new UsernameNotFoundException("Username " + username + " no existe!");
			
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(Role role: user.getRoles()) {
			logger.info("Role: ".concat(role.getAuthority()));
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		

		if(authorities.isEmpty()) {
			logger.error("Error:  " + username + " no tiene roles");
			throw new UsernameNotFoundException("Username " + username + " no tiene roles asignados");
			
		}
		return new User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}
	
	

}
