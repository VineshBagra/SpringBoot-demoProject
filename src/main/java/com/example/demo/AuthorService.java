package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Service
public class AuthorService {
    @Autowired
    AuthorsRepo authorsRepo;
    public List<Author> getAllAuthors()
    {
        List<Author>authors = new ArrayList<>();
        authorsRepo.findAll().forEach(authors:: add);
        return authors;
    }
    public Author getAuthorById(long authorId)
    {
        return authorsRepo.findById(authorId).get();
    }


    public void saveDone(Author author)
    {
        authorsRepo.save(author);
    }

    public void deleteByAuthorId(long authorId)
    {
        authorsRepo.deleteById(authorId);
    }

    public void update(Author author)
    {
        authorsRepo.save(author);
    }

}
