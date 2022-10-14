package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BooksRepo extends CrudRepository<Book,Long> {
    List<Book> findByAuthorId(long posId);
}
