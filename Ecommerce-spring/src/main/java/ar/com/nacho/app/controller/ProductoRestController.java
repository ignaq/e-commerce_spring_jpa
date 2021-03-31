package ar.com.nacho.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.nacho.app.model.entity.Producto;
import ar.com.nacho.app.model.service.IProductoService;

@Controller
@RestController
public class ProductoRestController {


	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping(value = {"/productos"} , produces = {"application/json"})
	public @ResponseBody List<Producto> listado(){
		
		return productoService.findAll();
	
	}
	
	
	
}
