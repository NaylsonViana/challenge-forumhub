package com.forum.hub.dto;

import com.forum.hub.model.Resposta;
import lombok.Data;

@Data
public class RespostaDTO {
    private Long id;
    private String mensagem;

    public RespostaDTO(Resposta resposta) {
        this.id = resposta.getId();
        this.mensagem = resposta.getMensagem();
    }
}
