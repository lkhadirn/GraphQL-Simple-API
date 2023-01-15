package com.example.graphqlapi.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.graphqlapi.models.Book;
import com.example.graphqlapi.repositories.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService{

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book create(Book book) {
        return repository.save(book);
    }

    @Override
    public Book update(Book book) {
        return repository.saveAndFlush(book);
    }

    @Override
    public Book getOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public long getTotal() {
        return repository.count();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Book> findAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
