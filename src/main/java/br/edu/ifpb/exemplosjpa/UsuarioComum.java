package br.edu.ifpb.exemplosjpa;


import jakarta.persistence.Entity;

@Entity
public class UsuarioComum extends Usuario {

    private String local;

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
