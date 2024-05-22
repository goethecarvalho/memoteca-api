package br.com.core.memoteca.domain.pensamento.vo;

import java.io.Serializable;

public record DadosPensamento(
        Long id,
        String conteudo,
        String autoria,
        Long idUsuario) implements Serializable {

    public DadosPensamento(String conteudo, String autoria, Long idUsuario) {
        this(null, conteudo, autoria, idUsuario);
    }

}
