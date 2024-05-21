package br.com.core.memoteca.domain.repository;

import br.com.core.memoteca.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
