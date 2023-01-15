package com.example.graphqlapi.controllers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;

import com.example.graphqlapi.models.Author;
import com.example.graphqlapi.models.Book;
import com.example.graphqlapi.services.AuthorService;
import com.example.graphqlapi.services.BookService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BookGraphQLController {
    private final AuthorService authorService;
    private final BookService bookService;

    public BookGraphQLController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @QueryMapping
    public List<Book> getBooks() {
        return bookService.getAll();
    }

    @QueryMapping
    public List<Author> getAuthors() {
        return authorService.getAll();
    }

    @QueryMapping
    public Book getBook(@Argument long id) {
        return bookService.getOne(id);
    }

    @QueryMapping
    public Author getAuthor(@Argument long id) {
        return authorService.getOne(id);
    }

    @MutationMapping
    public Book addBook(@Argument @Valid BookInput bookInput) {
        Author author = authorService.getOne((long) bookInput.authorId());
        if (ObjectUtils.isEmpty(author)) {
            throw new RuntimeException();
        }

        Book book = EntityMapper.toBookEntity(bookInput);
        book.setAuthor(author);
        return bookService.create(book);
    }

    @MutationMapping
    public Book updateBook(@Argument int id, @Argument @Valid BookInput bookInput) {
        Book book = bookService.getOne((long) id);
        if (ObjectUtils.isEmpty(book)) {
            throw new RuntimeException("book not found!");
        }

        book.setPage(bookInput.page());
        book.setPrice(bookInput.price());
        book.setTitle(bookInput.title());
        book.setIsbn(bookInput.isbn());
        book.setDescription(bookInput.description());

        return bookService.update(book);
    }

    @MutationMapping
    public Author addAuthor(@Argument @Valid AuthorInput authorInput) {
        Author author = EntityMapper.toAuthorEntity(authorInput);
        return authorService.create(author);
    }

    @MutationMapping
    public int deleteBook(@Argument int id) {
        authorService.delete((long) id);
        return id;
    }
}
