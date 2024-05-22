package br.com.core.memoteca.domain.usuario.repository;


import br.com.core.memoteca.domain.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
