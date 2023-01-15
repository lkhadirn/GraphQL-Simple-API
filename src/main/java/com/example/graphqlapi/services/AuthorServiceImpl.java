package com.example.graphqlapi.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.graphqlapi.models.Author;
import com.example.graphqlapi.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Author author) {
        return authorRepository.saveAndFlush(author);
    }

    @Override
    public Author getOne(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public long getTotal() {
        return authorRepository.count();
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);

    }

    @Override
    public Page<Author> findAllPaginate(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }
}
