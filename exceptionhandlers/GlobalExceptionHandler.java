package com.example.librarymanagmentsystem.exceptionhandlers;


import com.example.librarymanagmentsystem.dtos.ExceptionDTO;
import com.example.librarymanagmentsystem.exceptions.booksexception.AuthorNotFoundException;
import com.example.librarymanagmentsystem.exceptions.booksexception.BookNotFoundException;
import com.example.librarymanagmentsystem.exceptions.booksexception.GenreNotFoundException;
import com.example.librarymanagmentsystem.exceptions.lendingexceptions.LendingHistoryNotFoundException;
import com.example.librarymanagmentsystem.exceptions.patronexceptions.PatronNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleAuthorNotFoundException(AuthorNotFoundException authorNotFoundException) {
        ExceptionDTO dto = new ExceptionDTO();
        dto.setMessage("Author with name " + authorNotFoundException.getName() + " not found");
        dto.setResoultion("AuthorNotFoundException");
        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }


    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleBookNotFoundException(BookNotFoundException bookNotFoundException) {
        ExceptionDTO dto = new ExceptionDTO();
        dto.setMessage("Book with title " + bookNotFoundException.getTitle() + " not found");
        dto.setResoultion("BookNotFoundException");
        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }


    @ExceptionHandler(GenreNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleGenreNotFoundException(GenreNotFoundException genreNotFoundException) {
        ExceptionDTO dto = new ExceptionDTO();
        dto.setMessage("Genre " + genreNotFoundException.getGenre() + " not found");
        dto.setResoultion("GenreNotFoundException");
        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(LendingHistoryNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleLendingHistoryNotFoundException(LendingHistoryNotFoundException lendingHistoryNotFoundException) {
        ExceptionDTO dto = new ExceptionDTO();
        dto.setMessage("Lending History with id " + lendingHistoryNotFoundException.getId() + " not found");
        dto.setResoultion("LendingHistoryNotFoundException");
        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }


    @ExceptionHandler(PatronNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handlePatronNotFoundException(PatronNotFoundException patronNotFoundException) {
        ExceptionDTO dto = new ExceptionDTO();
        dto.setMessage("Patron with id " + patronNotFoundException.getId() + " not found");
        dto.setResoultion("PatronNotFoundException");
        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }

}
