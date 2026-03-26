package com.clubdeportivo.usuarios.services;

import java.util.List;

import com.clubdeportivo.usuarios.model.Usuario;

public interface UsuarioService {
    List <Usuario> listarUsuarios();

    Usuario crearUsuario(Usuario usuario);

    Usuario buscarUsuario(Long id);
    
    void eliminarUsuario(Long id);
}
