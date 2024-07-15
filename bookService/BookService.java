package com.example.librarymanagmentsystem.services.bookService;
//package com.example.librarymanagmentsystem.models.bookModel.Book;

import com.example.librarymanagmentsystem.models.bookModel.Book;
import com.example.librarymanagmentsystem.models.bookModel.Genre;
import com.example.librarymanagmentsystem.dtos.BookDTO;

import java.util.List;

public interface BookService {
    Book getBookByTitle(String title);

    List<Book> getAllBookByAuthor(String author);

    List<Book> getAllBookByGenre(Genre genre);

    List<Book> getAllBooks();

    Book createBook(BookDTO book);

    Book updateBook(Long id, BookDTO bookDTO);

    void deleteBook(Long id);
}
