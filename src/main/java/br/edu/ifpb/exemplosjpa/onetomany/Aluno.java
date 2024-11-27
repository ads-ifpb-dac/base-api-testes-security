package br.edu.ifpb.exemplosjpa.onetomany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Aluno {

    @Id
    private String matricula;

    @ManyToOne
    private Classe classe;

    @ManyToOne
    private Orientador orientador;

    @ManyToMany
    private Set<Curso> cursos = new LinkedHashSet<>();

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public void imprimirDadosAluno() {
        System.out.println("Aluno " + matricula);
    }

    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    public void addCurso(Curso curso) {
        this.cursos.add(curso);
    }
}
