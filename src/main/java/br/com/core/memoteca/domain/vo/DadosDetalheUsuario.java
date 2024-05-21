package br.com.core.memoteca.domain.vo;

import br.com.core.memoteca.domain.entity.Usuario;

import java.io.Serializable;
import java.time.LocalDate;

public record DadosDetalheUsuario (
        Long id,
        String nome,
        String login,
        String senha) implements Serializable {

    public DadosDetalheUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getSenha());
    }

}
