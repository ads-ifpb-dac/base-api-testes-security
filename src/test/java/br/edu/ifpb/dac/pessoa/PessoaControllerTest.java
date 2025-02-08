package br.edu.ifpb.dac.pessoa;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Testcontainers
class PessoaControllerTest {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Autowired
    private MockMvc mvc;

    @Test
    void criarPessoa() throws Exception {
        String json = """
                {
                    "nome": "Diogo",
                    "sobrenome": "Moreira",
                    "cpf": "00000000000",
                    "dataNascimento": "1989-02-02"
                }
                """;
        mvc.perform(post("/pessoas")
                        .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

    @Test
    void criarPessoaBadRequest() throws Exception {
        // Neste caso, o CPF é inválido, então vamos esperar uma resposta com código 400
        String json = """
                {
                    "nome": "Diogo",
                    "sobrenome": "Moreira",
                    "cpf": "000000000",
                    "dataNascimento": "1989-02-02"
                }
                """;
        mvc.perform(post("/pessoas")
                        .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
    }
}