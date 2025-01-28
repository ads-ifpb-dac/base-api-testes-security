package br.edu.ifpb.dac.pessoa;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void salvar(Pessoa pessoa) {
        this.pessoaRepository.save(pessoa);
    }

    public void remover(Long id) {
        Pessoa pessoa = this.pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaException(id));
        pessoaRepository.delete(pessoa);
    }

    public void atualizar(Pessoa pessoa) {
        this.pessoaRepository.save(pessoa);
    }

    public Pessoa buscarPorId(Long id) {
        return this.pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaException(id));
    }

    public List<Pessoa> buscarTodos() {
        return this.pessoaRepository.findAll();
    }

    public List<Pessoa> buscarPorNome(String nome) {
        return this.pessoaRepository.findByNome(nome);
    }
}
