package com.yops.springboot.app.productos.controllers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yops.springboot.app.productos.models.entity.Producto;
import com.yops.springboot.app.productos.models.service.IProductoService;

@RestController
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	@Value("${server.port}")
	private Integer port;
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoService.findAll().stream().map(p ->{
			p.setPort(port);
			
			return p;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/listar/{id}")
	public Producto getProducto(@PathVariable Long id) throws Exception {		
		Producto p = productoService.finById(id);
		
		p.setPort(port);		
		
		return p;
	}

}
