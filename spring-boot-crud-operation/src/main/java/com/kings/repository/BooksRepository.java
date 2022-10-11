package com.kings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kings.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer>

{

}
