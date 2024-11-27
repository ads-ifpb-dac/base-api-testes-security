package br.edu.ifpb.exemplosjpa.loader;

import br.edu.ifpb.exemplosjpa.onetomany.Aluno;
import br.edu.ifpb.exemplosjpa.onetomany.Classe;
import br.edu.ifpb.exemplosjpa.onetoone.Assento;
import br.edu.ifpb.exemplosjpa.onetoone.Passageiro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Component
public class Loader implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(Loader.class);

    @PersistenceContext
    private final EntityManager entityManager;

    public Loader(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        Assento assento = new Assento();
//        assento.setNumero("11A");
//
//        entityManager.persist(assento);
//        Passageiro passageiro = new Passageiro();
//        passageiro.setAssento(assento);
//        passageiro.setNome("Diogo");
//
//        entityManager.persist(passageiro);

        Classe classe = entityManager.find(Classe.class, 2L);

        Set<Aluno> alunos = classe.getAlunos();
        alunos.forEach(Aluno::imprimirDadosAluno);
    }

}
