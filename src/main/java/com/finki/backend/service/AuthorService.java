package com.finki.backend.service;

import com.finki.backend.domain.Author;
import com.finki.backend.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<Author> findAll() {
        return repository.findAll();
    }

    public Author save(Author author) {
        return repository.save(author);
    }
}
