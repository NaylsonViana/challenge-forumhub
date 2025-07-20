package com.forum.hub.controller;

import com.forum.hub.dto.AuthDTO;
import com.forum.hub.model.Usuario;
import com.forum.hub.repository.UsuarioRepository;
import com.forum.hub.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthController(UsuarioRepository repository, PasswordEncoder encoder, JwtUtil jwtUtil) {
        this.repository = repository;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthDTO dto) {
        Usuario usuario = repository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (encoder.matches(dto.getSenha(), usuario.getSenha())) {
            return ResponseEntity.ok(jwtUtil.generateToken(usuario.getEmail()));
        } else {
            return ResponseEntity.badRequest().body("Senha inválida");
        }
    }
}
