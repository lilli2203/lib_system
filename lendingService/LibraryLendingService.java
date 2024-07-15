package com.example.librarymanagmentsystem.services.lendingService;

import com.example.librarymanagmentsystem.models.bookModel.Book;
import com.example.librarymanagmentsystem.models.lendingModel.Lending;
import com.example.librarymanagmentsystem.models.lendingModel.LendingStatus;
import com.example.librarymanagmentsystem.models.patronModel.Patron;
import com.example.librarymanagmentsystem.Repositories.LendingRepository;
import com.example.librarymanagmentsystem.dtos.LendingDTO;
import com.example.librarymanagmentsystem.exceptions.lendingexceptions.LendingHistoryNotFoundException;
import com.example.librarymanagmentsystem.services.bookService.BookService;
import com.example.librarymanagmentsystem.services.patronService.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LibraryLendingService implements LendingService {
    private final LendingRepository lendingRepository;
    private final PatronService patronService;
    private final BookService bookService;

    @Autowired
    public LibraryLendingService(LendingRepository lendingRepository, PatronService patronService, BookService bookService) {
        this.lendingRepository = lendingRepository;
        this.patronService = patronService;
        this.bookService = bookService;
    }

    @Override
    public Lending getLendingById(Long id) throws LendingHistoryNotFoundException {
        Lending lending = lendingRepository.findByLendingID(id);
        if (lending == null) {
            throw new LendingHistoryNotFoundException(id, "Invalid Lending ID");
        }
        return lending;
    }

    @Override
    public List<Lending> getAllLendings() {
        List<Lending> lendings = lendingRepository.findAll();
        return lendings;
    }

    @Override
    public Lending createLending(LendingDTO lendingDTO) {
        Patron patron = patronService.getPatronById(lendingDTO.getPatronID());
        Book book = bookService.getBookByTitle(lendingDTO.getBookTitle());
        Lending lending = new Lending(book, patron, lendingDTO.getDateBorrowed(), lendingDTO.getDueDate(), lendingDTO.getDateReturned(), lendingDTO.getLendingStatus());
        return lendingRepository.save(lending);
    }

    @Override
    public Lending updateLending(Long id, LendingDTO lendingDTO) throws LendingHistoryNotFoundException {
        Lending lending = lendingRepository.findByLendingID(id);
        if (lending == null) {
            throw new LendingHistoryNotFoundException(id, "Invalid Lending ID");
        }
        lending = update(id, lendingDTO);
        return lendingRepository.save(lending);
    }

    @Override
    public void deleteLending(Long id) throws LendingHistoryNotFoundException {
        Lending lending = lendingRepository.findByLendingID(id);
        if (lending == null) {
            throw new LendingHistoryNotFoundException(id, "Invalid Lending ID");
        }
        lendingRepository.delete(lending);
    }

    @Override
    public List<Lending> getLendingByPatronId(Long id) {
        Patron patron = patronService.getPatronById(id);

        return lendingRepository.findByPatron(patron);
    }


    @Override
    public List<Lending> getLendingByBookTitle(String title) {
        Book book = bookService.getBookByTitle(title);

        return lendingRepository.findByBook(book);
    }

    @Override
    public List<Lending> getLendingByLendingDate(Date date) {
        List<Lending> lending = lendingRepository.findByDateBorrowed(date);
        if (lending == null) {
            throw new LendingHistoryNotFoundException(Long.parseLong(String.valueOf(date)), "Invalid Lending Date");
        }
        return lending;
    }

    @Override
    public List<Lending> getLendingByDueDate(Date dueDate) {
        List<Lending> lending = lendingRepository.findByDueDate(dueDate);
        if (lending == null) {
            throw new LendingHistoryNotFoundException(Long.parseLong(String.valueOf(dueDate)), "Invalid Due Date");
        }
        return lending;
    }

    @Override
    public List<Lending> getLendingByStatus(LendingStatus status) {
        List<Lending> lending = lendingRepository.findByLendingStatus(status);
        if (lending == null) {
            throw new LendingHistoryNotFoundException(Long.parseLong(String.valueOf(status)), "Invalid Status");
        }
        return lending;
    }

    private Lending update(Long id, LendingDTO lendingDTO) {
        Patron patron = patronService.getPatronById(lendingDTO.getPatronID());
        Book book = bookService.getBookByTitle(lendingDTO.getBookTitle());
        Lending lending = lendingRepository.findByLendingID(id);
        lending.setPatron(patron);
        lending.setBook(book);
        lending.setDateBorrowed(lendingDTO.getDateBorrowed());
        lending.setDueDate(lendingDTO.getDueDate());
        lending.setDateReturned(lendingDTO.getDateReturned());
        lending.setLendingStatus(lendingDTO.getLendingStatus());
        return lending;
    }
}
