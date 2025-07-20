package com.forum.hub.dto;

import com.forum.hub.model.Topico;
import lombok.Data;

@Data
public class TopicoDTO {
    private Long id;
    private String titulo;
    private String mensagem;

    public TopicoDTO(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
    }
}
