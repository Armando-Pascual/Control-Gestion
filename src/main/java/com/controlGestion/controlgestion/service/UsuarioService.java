package com.controlGestion.controlgestion.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlGestion.controlgestion.model.UsuarioModel;
import com.controlGestion.controlgestion.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Registrar un nuevo usuario
    public UsuarioModel registrarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    // Autenticar usuario por correo y contraseña
    public Optional<UsuarioModel> autenticar(String correo, String password) {
        return usuarioRepository.findByCorreo(correo)
                .filter(usuario -> usuario.getPassword().equals(password));
    }

    public List<UsuarioModel> listarPorRol(String rol) {
        return usuarioRepository.findByRolIgnoreCase(rol);
    }


}   
