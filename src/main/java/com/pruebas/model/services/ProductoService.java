package com.pruebas.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebas.model.Producto;
import com.pruebas.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
	private ProductoRepository repository;
   
    public List<Producto> listar(){
        return repository.findAll();
    }

    public Producto buscar(Long id){
        return repository.findById(id).orElseThrow(() ->
              new RuntimeException("Producto no encontrado"));
    }

    public Producto registrar(Producto producto){
        return repository.save(producto);
    }

}