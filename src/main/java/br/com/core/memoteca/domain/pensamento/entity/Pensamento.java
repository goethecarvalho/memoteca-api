package br.com.core.memoteca.domain.pensamento.entity;

import br.com.core.memoteca.domain.pensamento.vo.DadosPensamento;
import br.com.core.memoteca.domain.usuario.entity.Usuario;
import br.com.core.memoteca.domain.usuario.vo.DadosUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pensamentos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pensamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String conteudo;
    private String autoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public void atualizarDados(DadosPensamento dados) {
        this.conteudo = dados.conteudo();
        this.autoria = dados.autoria();
    }

    public Pensamento(DadosPensamento dados, Usuario usuario) {
        this.conteudo = dados.conteudo();
        this.autoria = dados.autoria();
        this.usuario = usuario;
    }

}
