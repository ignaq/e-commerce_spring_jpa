package ar.com.nacho.app.controller;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.com.nacho.app.model.entity.Cliente;
import ar.com.nacho.app.model.entity.Usuario;

@Controller
@SessionAttributes({"cliente"})
public class LoginController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/crear")
	public String crearUsuario(Model model) {
		Cliente cliente = new Cliente();
		Usuario usuario = new Usuario();
		
		model.addAttribute("cliente", cliente);
		model.addAttribute("usuario", usuario);
		
		return "/crear_usuario";
	}
	
	@RequestMapping(value="/crear" , method = RequestMethod.POST)
	public String crear(/* @RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password,*/ Cliente cliente, Usuario usuario) {
		Cliente cli = new Cliente();
		Usuario user = new Usuario();
		cli.setNombre(cliente.getNombre());
		cli.setApellido(cliente.getApellido());
		cli.setEmail(cliente.getEmail());
	
		String bcryptPassword = null;
		String password = cliente.getUsuario().getPassword();
		for(int i=0; i<2; i++) {
			bcryptPassword = passwordEncoder.encode(password);
			System.out.println(bcryptPassword);
		}
		
		if (bcryptPassword !=null) {
			user.setUsername(cliente.getUsuario().getUsername());
			user.setPassword(bcryptPassword);
			cli.setUsuario(user);
		}
		
		
		
		
		System.out.println(cli.getNombre());
		System.out.println(cli.getApellido());
		System.out.println(cli.getEmail());
		System.out.println(cli.getUsuario().getUsername());
		System.out.println(cli.getUsuario().getPassword());
				
		return "redirect:/";
	}
	
	
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			Model model,Principal principal, RedirectAttributes flash ) {
		

		
		
		
		if(principal != null) {
			flash.addFlashAttribute("info","Ya has iniciado sesión");
			return "redirect:/";
		} 
		
		if(error != null) {
			model.addAttribute("error", "El nombre de usuario o la contraseña son incorrectos");
		}
		
		if(logout != null) {
			model.addAttribute("success", "Sesión cerrada correctamente!");
		}
		return "login";
	}
	
}
