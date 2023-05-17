package com.example.biblioteka.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.Date;

import com.example.biblioteka.model.Livro;
import com.example.biblioteka.repository.LivroRepository;
import org.junit.Before;
import org.junit.Test;

public class LivroServiceTest {

    private LivroRepository livroRepository;
    private LivroService livroService;

    @Before
    public void setUp() {
        livroRepository = mock(LivroRepository.class);
        livroService = new LivroService(livroRepository);
    }

    @Test
    public void testCadastrarLivro() {
        Livro livro = new Livro();
        livro.setTitulo("Livro de Teste");
        livro.setResumo("Resumo do livro de teste");
        livro.setPreco(new BigDecimal("30.00"));
        livro.setNumeroPaginas(150);
        livro.setIsbn("978-1-234567-89-0");
        livro.setDataPublicacao(new Date());

        when(livroRepository.save(livro)).thenReturn(livro);

        Livro livroCadastrado = livroService.cadastrarLivro(livro);

        assertNotNull(livroCadastrado);
        assertEquals("Livro de Teste", livroCadastrado.getTitulo());
        assertEquals("Resumo do livro de teste", livroCadastrado.getResumo());
        assertEquals(new BigDecimal("30.00"), livroCadastrado.getPreco());
        assertEquals(Integer.valueOf(150), livroCadastrado.getNumeroPaginas());
        assertEquals("978-1-234567-89-0", livroCadastrado.getIsbn());
        assertEquals(new Date(), livroCadastrado.getDataPublicacao());

        verify(livroRepository, times(1)).save(livro);
    }
}

