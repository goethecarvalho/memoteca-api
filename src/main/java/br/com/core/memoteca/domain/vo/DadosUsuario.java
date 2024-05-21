package br.com.core.memoteca.domain.vo;

import java.io.Serializable;
import java.time.LocalDate;

public record DadosUsuario(
        Long id,
        String nome,
        String login,
        String senha) implements Serializable {

    public DadosUsuario(String nome, String login, String senha) {
        this(null, nome, login, senha);
    }

}
