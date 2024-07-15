package com.example.librarymanagmentsystem.Controllers;

import com.example.librarymanagmentsystem.models.bookModel.Author;
import com.example.librarymanagmentsystem.services.authorService.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


        @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable("id") Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable("id") Long id, @RequestBody Author author) {
        return authorService.updateAuthor(id, author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable("id") Long id) {
        authorService.deleteAuthor(id);
    }

    @GetMapping("/search")
    public List<Author> searchAuthorsByName(@RequestParam("name") String name) {
        return authorService.searchAuthorsByName(name);
    }

    @GetMapping("/nationality/{nationality}")
    public List<Author> getAuthorsByNationality(@PathVariable("nationality") String nationality) {
        return authorService.getAuthorsByNationality(nationality);
    }

    @PostMapping("/batchCreate")
    public List<Author> batchCreateAuthors(@RequestBody List<Author> authors) {
        return authorService.batchCreateAuthors(authors);
    }

    @PutMapping("/batchUpdate")
    public List<Author> batchUpdateAuthors(@RequestBody List<Author> authors) {
        return authorService.batchUpdateAuthors(authors);
    }

    @DeleteMapping("/batchDelete")
    public void batchDeleteAuthors(@RequestBody List<Long> authorIds) {
        authorService.batchDeleteAuthors(authorIds);
    }

    @GetMapping("/export")
    public void exportAuthorsToCSV() {
        authorService.exportAuthorsToCSV();
    }

    @PostMapping("/import")
    public List<Author> importAuthorsFromCSV(@RequestBody String csvData) {
        return authorService.importAuthorsFromCSV(csvData);
    }
}
