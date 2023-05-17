package com.example.biblioteka.controller;




import com.example.biblioteka.model.Livro;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LivroControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCadastrarLivro() {
        Livro livro = new Livro();
        livro.setTitulo("Livro de Teste");
        livro.setResumo("Resumo do livro de teste");
        livro.setPreco(new BigDecimal("30.00"));
        livro.setNumeroPaginas(150);
        livro.setIsbn("978-1-234567-89-0");
        livro.setDataPublicacao(new Date());

        ResponseEntity<Livro> response = restTemplate.postForEntity("/api/livros", livro, Livro.class);

        Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());

        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getId());
    }



}

