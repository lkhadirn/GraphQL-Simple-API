package com.example.graphqlapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.graphqlapi.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
