package br.edu.ifpb.dac.pessoa;

public class DadosPessoaInvalidosException extends RuntimeException {

    private Pessoa pessoa;

    public DadosPessoaInvalidosException(String message, Pessoa nome) {
        super(message);
        this.pessoa = nome;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
}
