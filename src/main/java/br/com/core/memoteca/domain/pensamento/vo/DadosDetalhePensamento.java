package br.com.core.memoteca.domain.pensamento.vo;

import br.com.core.memoteca.domain.pensamento.entity.Pensamento;

import java.io.Serializable;

public record DadosDetalhePensamento(
        Long id,
        String nome,
        String login,
        Long idUsuario) implements Serializable {

    public DadosDetalhePensamento(Pensamento pensamento) {
        this(pensamento.getId(), pensamento.getDescricao(), pensamento.getAutoria(), pensamento.getUsuario().getId());
    }

}
