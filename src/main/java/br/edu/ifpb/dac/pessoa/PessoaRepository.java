package br.edu.ifpb.dac.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findByNome(String nome);
    List<Pessoa> findByNomeAndSobrenome(String nome, String sobrenome);

}
