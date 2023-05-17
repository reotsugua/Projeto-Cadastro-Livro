package com.example.biblioteka.controller;

import com.example.biblioteka.model.Livro;
import com.example.biblioteka.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro) {
        Livro livroCadastrado = livroService.cadastrarLivro(livro);
        return ResponseEntity.ok(livroCadastrado);
    }



}

