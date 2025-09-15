
package com.controlGestion.controlgestion.repository;
import com.controlGestion.controlgestion.model.UsuarioModel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    Optional<UsuarioModel> findByCorreo(String correo);
    List<UsuarioModel> findByRolIgnoreCase(String rol);

}
