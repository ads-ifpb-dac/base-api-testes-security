package br.edu.ifpb.exemplosjpa;

import jakarta.persistence.Entity;

@Entity
public class UsuarioAdministrador extends Usuario {

    private String cargo;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
