package com.forum.hub.service;

import com.forum.hub.model.Topico;
import com.forum.hub.repository.TopicoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TopicoService {

    private final TopicoRepository repository;

    public TopicoService(TopicoRepository repository) {
        this.repository = repository;
    }

    public List<Topico> listar() {
        return repository.findAll();
    }

    public Topico buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
    }

    public Topico criar(Topico topico) {
        return repository.save(topico);
    }

    public Topico atualizar(Long id, Topico dados) {
        Topico topico = buscarPorId(id);
        topico.setTitulo(dados.getTitulo());
        topico.setMensagem(dados.getMensagem());
        return repository.save(topico);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
