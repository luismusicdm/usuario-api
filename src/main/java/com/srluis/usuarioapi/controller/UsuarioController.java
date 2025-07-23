package com.srluis.usuarioapi.controller;

import com.srluis.usuarioapi.entity.Usuario;
import com.srluis.usuarioapi.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Endpoint maroto pra ver se tá tudo OK e ainda listar a galera com paginação
    @GetMapping("/status")
    public ResponseEntity<Page<Usuario>> status(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        Page<Usuario> usuarios = usuarioService.listarUsuariosComPaginacao(page, size);
        return ResponseEntity.ok(usuarios); // se não deu erro, tá 200 OK!
    }

    // POST: cadastro de usuário
    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@Valid @RequestBody Usuario usuario) {
        Usuario salvo = usuarioService.salvar(usuario);
        return ResponseEntity.ok(salvo);
    }

    // PUT: atualiza o cidadão pelo ID e e-mail
    @PutMapping
    public ResponseEntity<?> atualizar(
            @RequestParam Long id,
            @RequestParam String email,
            @RequestBody Usuario novosDados
    ) {
        Optional<Usuario> existente = usuarioService.buscarPorEmail(email);
        if (existente.isPresent() && existente.get().getId().equals(id)) {
            Optional<Usuario> atualizado = usuarioService.atualizar(id, novosDados);
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.status(404).body("Usuário não encontrado ou ID/email não batem");
        }
    }

    // DELETE: tchau e bença
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
