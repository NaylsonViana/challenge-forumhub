package com.forum.hub.controller;

import com.forum.hub.model.Resposta;
import com.forum.hub.service.RespostaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

    private final RespostaService service;

    public RespostaController(RespostaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Resposta> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Resposta> criar(@RequestBody Resposta resposta) {
        return ResponseEntity.ok(service.criar(resposta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
