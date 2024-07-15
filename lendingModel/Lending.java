package com.example.librarymanagmentsystem.models.lendingModel;

import com.example.librarymanagmentsystem.models.patronModel.Patron;
import com.example.librarymanagmentsystem.models.bookModel.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Lending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lendingID;
    @ManyToOne
    private Book book;
    @ManyToOne
    private Patron patron;
    private Date dateBorrowed;
    private Date dueDate;
    private Date dateReturned;
    private LendingStatus lendingStatus;

    public Lending(Book book, Patron patron, Date dateBorrowed, Date dueDate, Date dateReturned, LendingStatus lendingStatus) {
        this.book = book;
        this.patron = patron;
        this.dateBorrowed = dateBorrowed;
        this.dueDate = dueDate;
        this.dateReturned = dateReturned;
        this.lendingStatus = lendingStatus;
    }
}
