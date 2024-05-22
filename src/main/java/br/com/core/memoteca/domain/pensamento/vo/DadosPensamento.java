package br.com.core.memoteca.domain.pensamento.vo;

import java.io.Serializable;

public record DadosPensamento(
        Long id,
        String descricao,
        String autoria,
        Long idUsuario) implements Serializable {

    public DadosPensamento(String descricao, String autoria, Long idUsuario) {
        this(null, descricao, autoria, idUsuario);
    }

}
