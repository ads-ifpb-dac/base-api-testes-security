package br.edu.ifpb.exemplosjpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;

@Entity
public class Pessoa {

    @Id
    @TableGenerator(
            name = "table_gen",
            table = "sequencias",
            pkColumnName = "nome_sequencia",
            pkColumnValue = "pessoa_seq",
            valueColumnName = "seq_contador",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table_gen")
    private Long id;
    private String nome;

    public Pessoa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
