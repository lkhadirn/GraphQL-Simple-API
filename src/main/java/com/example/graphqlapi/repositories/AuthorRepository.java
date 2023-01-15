package com.example.graphqlapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.graphqlapi.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
