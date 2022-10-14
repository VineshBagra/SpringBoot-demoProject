package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthorController {
    @Autowired
    AuthorService authorService;
   /*@GetMapping("/authors")
    public List<Author> getAllAuthors()
   {
       //List<Author> authors=new ArrayList<>();

       authorsRepo.findAll().forEach(authors::add);
       if (authors.isEmpty()) {
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
       return new ResponseEntity<>(authors, HttpStatus.OK);
   }
    @GetMapping("/authors/{authorId}")
    public Author getAuthorById(@PathVariable("authorId") long id) {
       */
   @GetMapping("/author")
   private List<Author> getAllAuthors()
   {
       return authorService.getAllAuthors();
   }
    @GetMapping("/author/{authorId}")
    private Author getAuthor(@PathVariable ("authorId") int id)
    {
        return authorService.getAuthorById(id);
    }
    @PostMapping("/author")
    private void saveAuthor(@RequestBody Author author)
    {
        System.out.println();
        authorService.saveDone(author);
    }
    @DeleteMapping("/author/{authorId}")
    private void deleteAuthor(@PathVariable ("authorId") int id)
    {
        authorService.deleteByAuthorId(id);
    }

    @PutMapping("/author/{authorId}")
    private void updateAuthor(@RequestBody Author author)
    {
        authorService.update(author);
    }


    }

