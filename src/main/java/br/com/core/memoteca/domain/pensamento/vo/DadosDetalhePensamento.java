package br.com.core.memoteca.domain.pensamento.vo;

import br.com.core.memoteca.domain.pensamento.entity.Pensamento;

import java.io.Serializable;

public record DadosDetalhePensamento(
        Long id,
        String conteudo,
        String autoria,
        Long idUsuario) implements Serializable {

    public DadosDetalhePensamento(Pensamento pensamento) {
        this(pensamento.getId(), pensamento.getConteudo(), pensamento.getAutoria(), pensamento.getUsuario().getId());
    }

}
