package com.pruebas.model.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebas.model.Usuario;
import com.pruebas.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
    private UsuarioRepository repository;

    public Usuario registrar(Usuario usuario){
        Optional<Usuario> existe = repository.findByEmail(usuario.getEmail());
        if(existe.isPresent()){
            throw new RuntimeException("Correo ya registrado");
        }
        return repository.save(usuario);

    }

    public Usuario login(String email,String password){
        Usuario usuario = repository.findByEmail(email).orElseThrow(() ->
                    new RuntimeException("Usuario no encontrado"));
        if(!usuario.getPassword().equals(password)){
            throw new RuntimeException("Contraseña incorrecta");
        }
        return usuario;
    }

}