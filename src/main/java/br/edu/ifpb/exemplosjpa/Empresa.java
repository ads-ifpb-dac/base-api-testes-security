package br.edu.ifpb.exemplosjpa;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Empresa {

    @Id
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "logradouro",
                    column = @Column(name = "logradouro_empresa")
            ),
            @AttributeOverride(
                    name = "complemento",
                    column = @Column(name = "numero_sala")
            ),
    })
    private Endereco endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
