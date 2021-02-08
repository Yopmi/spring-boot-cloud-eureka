package com.yops.springboot.app.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yops.springboot.app.productos.models.dao.IProductoDao;
import com.yops.springboot.app.productos.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private IProductoDao productoDao;

	public List<Producto> findAll() {	
		
		return (List<Producto>)productoDao.findAll();
	}

	public Producto finById(Long id) {
		
		return productoDao.findById(id).orElse(null);
	}

}
