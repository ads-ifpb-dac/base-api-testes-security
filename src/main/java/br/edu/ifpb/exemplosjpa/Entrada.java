package br.edu.ifpb.exemplosjpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Entrada {

    @Id
    private String id;
    private LocalDate dataEvento;

    public Entrada() {
    }

    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID().toString().split("-")[0];
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
