package com.example.librarymanagmentsystem.models.bookModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String title;
    @ManyToOne()
    private Author author ;
    private Genre genre;
    private Date publicationDate;
    private String ISBN;

    public Book(String title, Author author, Genre genre, Date publicationDate, String ISBN) {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationDate = publicationDate;
    }

}
