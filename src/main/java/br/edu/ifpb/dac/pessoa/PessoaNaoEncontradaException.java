package br.edu.ifpb.dac.pessoa;

public class PessoaNaoEncontradaException extends RuntimeException {

    private Long id;

    public PessoaNaoEncontradaException(Long id) {
        super("Não foi possível encontrar Pessoa com ID " + id);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
