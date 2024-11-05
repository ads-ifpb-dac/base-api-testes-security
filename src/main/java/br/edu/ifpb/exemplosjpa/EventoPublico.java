package br.edu.ifpb.exemplosjpa;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("publico")
public class EventoPublico extends Evento {

    private Long lotacaoMaxima;

    public EventoPublico() {
    }

    public Long getLotacaoMaxima() {
        return lotacaoMaxima;
    }

    public void setLotacaoMaxima(Long lotacaoMaxima) {
        this.lotacaoMaxima = lotacaoMaxima;
    }
}
