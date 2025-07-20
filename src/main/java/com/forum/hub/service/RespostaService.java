package com.forum.hub.service;

import com.forum.hub.model.Resposta;
import com.forum.hub.repository.RespostaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RespostaService {

    private final RespostaRepository repository;

    public RespostaService(RespostaRepository repository) {
        this.repository = repository;
    }

    public List<Resposta> listar() {
        return repository.findAll();
    }

    public Resposta buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Resposta não encontrada"));
    }

    public Resposta criar(Resposta resposta) {
        return repository.save(resposta);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
