package br.edu.ifpb.exemplosjpa.loader;

import br.edu.ifpb.exemplosjpa.Pessoa;
import br.edu.ifpb.exemplosjpa.Sexo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

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
    }

}
