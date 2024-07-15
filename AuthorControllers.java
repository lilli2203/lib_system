package com.example.librarymanagmentsystem.Controllers;

import com.example.librarymanagmentsystem.models.bookModel.Author;
import com.example.librarymanagmentsystem.services.authorService.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorControllers {
    AuthorService authorService;

    AuthorControllers(AuthorService authorService) {
        this.authorService = authorService;
    }

    // Get All Authors
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    // Create an Author
    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    // Update an Author
    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable("id") Long id, @RequestBody Author author) {
        return authorService.updateAuthor(id, author);
    }

    // Delete an Author
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable("id") Long id) {
        authorService.deleteAuthor(id);
    }
}
