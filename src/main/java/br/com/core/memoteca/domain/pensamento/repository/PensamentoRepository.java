package br.com.core.memoteca.domain.pensamento.repository;

import br.com.core.memoteca.domain.pensamento.entity.Pensamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PensamentoRepository extends JpaRepository<Pensamento, Long> {
}
