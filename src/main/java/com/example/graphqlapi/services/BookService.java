package com.example.graphqlapi.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.graphqlapi.models.Book;

public interface BookService {

    Book create(Book book);

    Book update(Book book);

    Book getOne(Long id) ;

    List<Book> getAll();

    long getTotal();

    void delete(Long id);

    Page<Book> findAllPaginate(Pageable pageable);
}
