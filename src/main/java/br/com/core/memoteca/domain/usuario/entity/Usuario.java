package br.com.core.memoteca.domain.usuario.entity;

import br.com.core.memoteca.domain.usuario.vo.DadosDetalheUsuario;
import br.com.core.memoteca.domain.usuario.vo.DadosUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String login;

    private String senha;

    public Usuario(DadosDetalheUsuario dados) {
        this.id = dados.id();
        this.nome = dados.nome();
        this.login = dados.login();
        this.senha = dados.senha();
    }

    public Usuario(DadosUsuario dados) {
    }

    public void atualizarDados(DadosUsuario dados) {
        this.nome = dados.nome();
        this.login = dados.login();
        this.senha = dados.senha();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
