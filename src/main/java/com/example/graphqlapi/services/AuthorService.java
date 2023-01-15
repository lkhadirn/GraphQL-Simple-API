package com.example.graphqlapi.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.graphqlapi.models.Author;

public interface AuthorService {
    Author create(Author author);

    Author update(Author author);

    Author getOne(Long id);

    List<Author> getAll();

    long getTotal();

    void delete(Long id);

    Page<Author> findAllPaginate(Pageable pageable);
}
