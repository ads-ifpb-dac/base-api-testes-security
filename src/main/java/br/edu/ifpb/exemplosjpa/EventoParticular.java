package br.edu.ifpb.exemplosjpa;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("particular")
public class EventoParticular extends Evento {

    private String senha;

    public EventoParticular() {
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
