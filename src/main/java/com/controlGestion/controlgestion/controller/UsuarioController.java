package com.controlGestion.controlgestion.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.controlGestion.controlgestion.dto.UsuarioDto;
import com.controlGestion.controlgestion.model.UsuarioModel;
import com.controlGestion.controlgestion.repository.UsuarioRepository;
import com.controlGestion.controlgestion.service.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    // Registro de usuario
    @PostMapping("/registro")
    public ResponseEntity<UsuarioModel> registrar(@RequestBody UsuarioModel usuario) {
        UsuarioModel nuevo = usuarioService.registrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

@PostMapping("/login")
public ResponseEntity<UsuarioDto> login(@RequestBody UsuarioModel usuario) {
    Optional<UsuarioModel> usuarioEncontrado = usuarioRepository.findByCorreo(usuario.getCorreo());

    if (usuarioEncontrado.isPresent() &&
        usuarioEncontrado.get().getPassword().equals(usuario.getPassword())) {

        String nombre = usuarioEncontrado.get().getNombreUsuario();
        String rol = usuarioEncontrado.get().getRol();
        //String mensaje = "Bienvenido " + nombre;

        UsuarioDto respuesta = new UsuarioDto(nombre, rol);
        return ResponseEntity.ok(respuesta);
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}


    // Listar usuarios por rol (RECEPCION, ASIGNACION, REVISION)
    @GetMapping("/rol/{rol}")
    public ResponseEntity<List<UsuarioModel>> listarPorRol(@PathVariable String rol) {
        List<UsuarioModel> usuarios = usuarioService.listarPorRol(rol);
        return ResponseEntity.ok(usuarios);
    }
}
