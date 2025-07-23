package com.srluis.usuarioapi.service;

import com.srluis.usuarioapi.entity.Usuario;
import com.srluis.usuarioapi.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor // Lombok: injeta o repo sem precisar de @Autowired, que é meio jurássico
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Page<Usuario> listarUsuariosComPaginacao(int pagina, int tamanho) {
        // Vai buscar a galera toda, com paginação e ordenado por nome
        return usuarioRepository.findAll(PageRequest.of(pagina, tamanho, Sort.by("nome").ascending()));
    }

    public Usuario salvar(Usuario usuario) {
        // Bota o carimbo do tempo antes de salvar
        usuario.setTimestamp(LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Optional<Usuario> atualizar(Long id, Usuario novosDados) {
        // Atualização manual (só se achar o usuário mesmo)
        return usuarioRepository.findById(id).map(usuario -> {
            // Nome não vem? Deixa como tá.
            if (novosDados.getNome() != null) usuario.setNome(novosDados.getNome());
            if (novosDados.getDescricao() != null) usuario.setDescricao(novosDados.getDescricao());
            if (novosDados.getTelefone() != null) usuario.setTelefone(novosDados.getTelefone());
            if (novosDados.getRoles() != null) usuario.setRoles(novosDados.getRoles());
            if (novosDados.getSenha() != null) usuario.setSenha(novosDados.getSenha());
            if (novosDados.getContaBloqueada() != null) usuario.setContaBloqueada(novosDados.getContaBloqueada());
            return usuario;
        });
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
