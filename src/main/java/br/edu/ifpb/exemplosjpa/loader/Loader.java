package br.edu.ifpb.exemplosjpa.loader;

import br.edu.ifpb.exemplosjpa.Entrada;
import br.edu.ifpb.exemplosjpa.Evento;
import br.edu.ifpb.exemplosjpa.EventoParticular;
import br.edu.ifpb.exemplosjpa.EventoPublico;
import br.edu.ifpb.exemplosjpa.Ingresso;
import br.edu.ifpb.exemplosjpa.Pessoa;
import br.edu.ifpb.exemplosjpa.UsuarioAdministrador;
import br.edu.ifpb.exemplosjpa.UsuarioComum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

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
//        Pessoa p = new Pessoa();
//        p.setNome("Fulano");
//        entityManager.persist(p);
//
//        Evento evento = new Evento();
//        evento.setTitulo("SertaoComp");
//        entityManager.persist(evento);
//
//        Ingresso ingresso = new Ingresso();
//        ingresso.setValor(BigDecimal.valueOf(100L));
//        entityManager.persist(ingresso);
//
//        Entrada entrada = new Entrada();
//        entrada.setDataEvento(LocalDate.of(2024, 12, 1));
//        entityManager.persist(entrada);

        EventoParticular evento1 = new EventoParticular();
        evento1.setSenha("n124821374uihr");
        entityManager.persist(evento1);

        EventoPublico evento2 = new EventoPublico();
        evento2.setLotacaoMaxima(100000L);
        entityManager.persist(evento2);

//        UsuarioComum usuarioComum = new UsuarioComum();
//        usuarioComum.setLogin("fulano@email.com");
//        usuarioComum.setLocal("Cajazeiras, PB");
//        entityManager.persist(usuarioComum);
//
//        UsuarioAdministrador administrador = new UsuarioAdministrador();
//        administrador.setLogin("gerente@email.com");
//        administrador.setCargo("Gerente");
//        entityManager.persist(administrador);

    }

}
