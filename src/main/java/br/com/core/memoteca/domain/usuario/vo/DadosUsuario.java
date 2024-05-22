package br.com.core.memoteca.domain.usuario.vo;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record DadosUsuario(
        Long id,

        @NotBlank
        String nome,

        @NotBlank
        String login,

        @NotBlank
        String senha) implements Serializable {

    public DadosUsuario(String nome, String login, String senha) {
        this(null, nome, login, senha);
    }

}
