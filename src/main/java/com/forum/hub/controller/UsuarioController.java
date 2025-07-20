package com.forum.hub.controller;

import com.forum.hub.model.Usuario;
import com.forum.hub.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(service.criar(usuario));
    }

    @PostMapping("/corrigir-senhas")
    public ResponseEntity<String> corrigirSenhasAntigas() {
        service.corrigirSenhasAntigas();
        return ResponseEntity.ok("Senhas corrigidas com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
