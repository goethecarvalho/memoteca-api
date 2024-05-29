package br.com.core.memoteca.controller;

import br.com.core.memoteca.domain.pensamento.service.PensamentoService;
import br.com.core.memoteca.domain.pensamento.vo.DadosDetalhePensamento;
import br.com.core.memoteca.domain.pensamento.vo.DadosPensamento;
import br.com.core.memoteca.domain.usuario.service.UsuarioService;
import br.com.core.memoteca.domain.usuario.vo.DadosDetalheUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/api/pensamento")
public class PensamentoController {

    @Autowired
    private final PensamentoService pensamentoService;

    @Autowired
    private final UsuarioService usuarioService;

    public PensamentoController(PensamentoService pensamentoService, UsuarioService usuarioService) {
        this.pensamentoService = pensamentoService;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosPensamento dados, UriComponentsBuilder uriBuilder){
        DadosDetalheUsuario usuario = usuarioService.detalhar(dados.idUsuario());
        var dadosPensamentoCadastrado = pensamentoService.cadastrarPensamento(dados, usuario);
        var uri = uriBuilder.path("pensamentos/{id}").buildAndExpand(dadosPensamentoCadastrado.id()).toUri();
        return ResponseEntity.created(uri).body(dadosPensamentoCadastrado);
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhePensamento>> listar(@PageableDefault(size = 10, sort = {"autoria"}) Pageable paginacao) {
        var pensamento = pensamentoService.listar(paginacao);
        return ResponseEntity.ok(pensamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhePensamento> detalhar(@PathVariable Long id) {
        var pensamento = pensamentoService.detalhar(id);
        return ResponseEntity.ok(pensamento);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhePensamento> atualizar(@PathVariable Long id, @RequestBody @Valid DadosPensamento dados) {
        var pensamentoAtualizado = pensamentoService.atualizarPensamento(id, dados);
        return ResponseEntity.ok(pensamentoAtualizado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pensamentoService.deletarPensamento(id);
        return ResponseEntity.noContent().build();
    }

}
