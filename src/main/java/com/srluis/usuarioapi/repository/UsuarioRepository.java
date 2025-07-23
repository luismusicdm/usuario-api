package com.srluis.usuarioapi.repository;

import com.srluis.usuarioapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Pra buscar um usuário pelo e-mail. Clássico do login
    Optional<Usuario> findByEmail(String email);
}
