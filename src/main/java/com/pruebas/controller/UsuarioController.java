package com.pruebas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.model.Usuario;
import com.pruebas.model.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
	private UsuarioService service;

    @PostMapping("/registrar")
    public Usuario registrar(@RequestBody Usuario usuario){
        return service.registrar(usuario);
    }

    @GetMapping("/login")
    public Usuario login(@RequestParam String email,
                         @RequestParam String password){
        return service.login(email,password);
    }

}