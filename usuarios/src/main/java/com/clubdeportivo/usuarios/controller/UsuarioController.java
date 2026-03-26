package com.clubdeportivo.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clubdeportivo.usuarios.model.Usuario;
import com.clubdeportivo.usuarios.services.UsuarioService;

@RestController
@RequestMapping("/api/users")
public class UsuarioController {
    
    @Autowired
        private UsuarioService usuarioService;

        @GetMapping
        public List<Usuario> listarUsuarios(){
            return usuarioService.listarUsuarios();
        }

        @GetMapping("/{id}")
        public Usuario buscarUsuario(@PathVariable Long id){
            return usuarioService.buscarUsuario(id);
        }

        @PostMapping
        public Usuario crearUsuario(@RequestBody Usuario usuario){
            return usuarioService.crearUsuario(usuario);
        }

        @DeleteMapping("/{id}")
        public void eliminarUsuario(@PathVariable Long id) {
            usuarioService.eliminarUsuario(id);
        }
        
}
