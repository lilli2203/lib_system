package com.example.librarymanagmentsystem.Controllers;

import com.example.librarymanagmentsystem.Models.bookModel.Book;
import com.example.librarymanagmentsystem.Models.bookModel.Genre;
import com.example.librarymanagmentsystem.dtos.BookDTO;
import com.example.librarymanagmentsystem.services.bookService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Get Book by Title
    @GetMapping("/title/{title}")
    public Book getBookByTitle(@PathVariable("title") String title) {
        return bookService.getBookByTitle(title);
    }

    // Get All Books by Author
    @GetMapping("/author/{author}")
    public List<Book> getAllBookByAuthor(@PathVariable("author") String author) {
        return bookService.getAllBookByAuthor(author);
    }

    // Get All Books by Genre
    @GetMapping("/genre/{genre}")
    public List<Book> getAllBookByGenre(@PathVariable("genre") Genre genre) {
        return bookService.getAllBookByGenre(genre);
    }

    // Get All Books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book createBook(@RequestBody BookDTO bookDTO) {
        return bookService.createBook(bookDTO);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable("id") Long id, @RequestBody BookDTO bookDTO) {
        return bookService.updateBook(id, bookDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/search")
    public List<Book> searchBooksByTitle(@RequestParam("keyword") String keyword) {
        return bookService.searchBooksByTitle(keyword);
    }

    @GetMapping("/year/{year}")
    public List<Book> getBooksByPublicationYear(@PathVariable("year") int year) {
        return bookService.getBooksByPublicationYear(year);
    }

    @GetMapping("/isbn/{isbn}")
    public Book getBookByIsbn(@PathVariable("isbn") String isbn) {
        return bookService.getBookByIsbn(isbn);
    }

    @PostMapping("/batchCreate")
    public List<Book> batchCreateBooks(@RequestBody List<BookDTO> bookDTOs) {
        return bookService.batchCreateBooks(bookDTOs);
    }

    @PutMapping("/batchUpdate")
    public List<Book> batchUpdateBooks(@RequestBody List<BookDTO> bookDTOs) {
        return bookService.batchUpdateBooks(bookDTOs);
    }

    @DeleteMapping("/batchDelete")
    public void batchDeleteBooks(@RequestBody List<Long> bookIds) {
        bookService.batchDeleteBooks(bookIds);
    }

    @GetMapping("/export")
    public void exportBooksToCSV() {
        bookService.exportBooksToCSV();
    }

    @PostMapping("/import")
    public List<Book> importBooksFromCSV(@RequestBody String csvData) {
        return bookService.importBooksFromCSV(csvData);
    }
}
