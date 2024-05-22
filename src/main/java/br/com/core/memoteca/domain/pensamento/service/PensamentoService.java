package br.com.core.memoteca.domain.pensamento.service;

import br.com.core.memoteca.domain.RegraDeNegocioException;
import br.com.core.memoteca.domain.pensamento.entity.Pensamento;
import br.com.core.memoteca.domain.pensamento.repository.PensamentoRepository;
import br.com.core.memoteca.domain.pensamento.vo.DadosDetalhePensamento;
import br.com.core.memoteca.domain.pensamento.vo.DadosPensamento;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PensamentoService {
    private final PensamentoRepository repository;

    public PensamentoService(PensamentoRepository repository) {
        this.repository = repository;
    }

    @Cacheable(value = "listaPensamentos")
    public Page<DadosDetalhePensamento> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosDetalhePensamento::new);
    }

    @CacheEvict(value = "listaPensamentos", allEntries = true)
    public DadosDetalhePensamento cadastrarPensamento(DadosPensamento dados) {
        if (dados.descricao() == null || dados.descricao().isEmpty()) {
            throw new RegraDeNegocioException("O pensamento deve estar preenchido!");
        }

        if (dados.autoria() == null || dados.autoria().isEmpty()) {
            throw new RegraDeNegocioException("A autoria deve estar preenchido!");
        }

        var pensamento = new Pensamento(dados);

        repository.save(pensamento);

        return new DadosDetalhePensamento(pensamento);
    }

    @CacheEvict(value = "listaPensamentos", allEntries = true)
    public DadosDetalhePensamento atualizarPensamento(Long id, DadosPensamento dados) {
        var pensamento = repository.findById(id).orElseThrow(() -> new RuntimeException("Pensamento não encontrado"));

        DadosPensamento pensamentoAtualizado = new DadosPensamento(
                dados.id(),
                dados.descricao(),
                dados.autoria(),
                dados.idUsuario()
        );

        pensamento.atualizarDados(pensamentoAtualizado);

        repository.save(pensamento);

        return new DadosDetalhePensamento(pensamento);
    }

    public DadosDetalhePensamento detalhar(Long id) {
        var pensamento = repository.findById(id).get();
        return new DadosDetalhePensamento(pensamento);
    }

    @CacheEvict(value = "listaPensamentos", allEntries = true)
    public void deletarPensamento(Long id) {
        var pensamento = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        repository.delete(pensamento);
    }
}
