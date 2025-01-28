package br.edu.ifpb.dac.pessoa;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public List<Pessoa> buscarTodos(@RequestParam(name = "nome", required = false) String nome) {
        if (StringUtils.hasText(nome))
            return this.pessoaService.buscarPorNome(nome);
        return this.pessoaService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Pessoa buscarPorId(@PathVariable Long id) {
        return this.pessoaService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody @Valid Pessoa pessoa) {
        this.pessoaService.salvar(pessoa);
        return ResponseEntity.ok(pessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@RequestBody Pessoa pessoa, @PathVariable Long id) {
        Pessoa pessoaExistente = this.pessoaService.buscarPorId(id);
        if (pessoaExistente == null) {
            return ResponseEntity.notFound().build();
        }
        pessoa.setId(id);
        pessoaService.atualizar(pessoa);
        return ResponseEntity.ok(pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletarPessoa(@PathVariable Long id) {
        this.pessoaService.remover(id);
    }

}
