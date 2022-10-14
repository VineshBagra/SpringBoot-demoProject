package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    BooksRepo booksRepo;
    @Autowired
    AuthorService authorService;
    @Autowired
    AuthorsRepo authorsRepo;

    @GetMapping("/author/{authorId}/book")
    private List<Book> getAllBook(@PathVariable(value = "authorId") long authorId)
    {
        List<Book> books = bookService.getAuthorById(authorId);
        return books;
    }

    @GetMapping("/book")
    private String getBook(@RequestParam(name="bookId") int id)
    {
        System.out.println(id);
        return bookService.getBookById(id).getAuthor().getFirstName();
    }
    @PostMapping("/author/{authorId}/book")
    private void saveBook(@PathVariable(value = "authorId") Long authorId,
                          @RequestBody Book bookRequest)
    {   Author author= authorService.getAuthorById(authorId);
        bookRequest.setAuthor(author);
         booksRepo.save(bookRequest);

    }

    @DeleteMapping("/book/{bookId}")
    private void deleteBook(@PathVariable ("bookId") int bookId)
    {
        bookService.deleteByBookId(bookId);
    }
    @DeleteMapping("/author/{authorId}/book")
    public void deleteAllBooksOfAuthor(@PathVariable(value = "authorId") long authorId) {
        if (!authorService.authorsRepo.existsById(authorId)) {
            System.out.println("Not found Tutorial with id = " + authorId);
        }
        bookService.deleteByAuthorId(authorId);

    }
    @PutMapping("/book/{id}")
    private void updateBook(@PathVariable(value = "id") long id,@RequestBody Book bookRequest)
    {
        //Book book=bookService.getBookById(id);
        //book.
        if(bookService.getBookById(id)==null)
        {
            System.out.println("book not found");
            return;
        }
        booksRepo.save(bookRequest);
    }
}
