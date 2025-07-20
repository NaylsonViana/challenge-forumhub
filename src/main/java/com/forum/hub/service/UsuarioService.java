package com.forum.hub.service;

import com.forum.hub.model.Usuario;
import com.forum.hub.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Usuario criar(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return repository.save(usuario);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public void corrigirSenhasAntigas() {
        List<Usuario> usuarios = repository.findAll();
        for (Usuario usuario : usuarios) {
            String senha = usuario.getSenha();
            if (!(senha.startsWith("$2a$") || senha.startsWith("$2b$") || senha.startsWith("$2y$"))) {
                usuario.setSenha(passwordEncoder.encode(senha));
                repository.save(usuario);
            }
        }
    }
}
