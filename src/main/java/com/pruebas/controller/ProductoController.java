package com.pruebas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.model.Producto;
import com.pruebas.model.services.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
	private ProductoService service;

    @GetMapping
    public List<Producto> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Producto buscar(@PathVariable Long id){
        return service.buscar(id);
    }

    @PostMapping
    public Producto registrar(@RequestBody Producto producto){
        return service.registrar(producto);
    }
}