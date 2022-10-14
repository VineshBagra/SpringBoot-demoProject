package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class BookService {
    @Autowired
    BooksRepo booksRepo;
    @Autowired
    AuthorsRepo authorsRepo;
    public List<Book> getAllBooks()
    {
        List<Book>books = new ArrayList<>();
        booksRepo.findAll().forEach(books::add);
        return  books;
    }
    public List<Book> getAuthorById(long authorId)
    {
        return booksRepo.findByAuthorId(authorId);
    }
    public Book getBookById(long bookId)
    {
        System.out.println("Book id is " + bookId);
        return booksRepo.findById(bookId).get();
    }

    public void save(Book book)
    {
        booksRepo.save(book);
    }
    public void deleteByBookId(long bookId)
    {
        booksRepo.deleteById(bookId);
    }
    public  void deleteByAuthorId(long authorId)
    {
       booksRepo.deleteAll();
    }

}
