package br.edu.ifpb.dac.pessoa;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
@EnableAutoConfiguration(exclude = {FlywayAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
class PessoaServiceTest {

    @Autowired
    private PessoaService pessoaService;

    @MockBean
    private PessoaRepository pessoaRepository;

    @BeforeEach
    void setUp() throws Exception {
        Pessoa pessoaMock = new Pessoa();
        pessoaMock.setId(1L);
        pessoaMock.setNome("Fulano");
        pessoaMock.setSobrenome("Moreira");
        pessoaMock.setCpf("00000000000");
        pessoaMock.setDataNascimento(LocalDate.of(1989, 2, 2));

        when(pessoaRepository.save(Mockito.any(Pessoa.class))).thenReturn(new Pessoa());
        when(pessoaRepository.findByNomeAndSobrenome(anyString(), anyString())).thenReturn(List.of(pessoaMock));
    }

    @Test
    void salvar() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Fulano");
        pessoa.setSobrenome("da Silva");
        pessoaService.salvar(pessoa);
    }

    @Test
    void salvarComExcecao() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Fulano");
        pessoa.setSobrenome("Moreira");
        Assertions.assertThrows(DadosPessoaInvalidosException.class, () -> {
            pessoaService.salvar(pessoa);
        });
    }


}
