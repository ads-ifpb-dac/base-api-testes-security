package br.edu.ifpb.exemplosjpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(
        name = "evento_seq_gen",
        sequenceName = "evento_seq",
        allocationSize = 1
)
public class Evento {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "evento_seq_gen"
    )
    private Long id;
    private String titulo;

    public Evento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
