package com.example.librarymanagmentsystem.services.patronService;

import com.example.librarymanagmentsystem.exceptions.patronexceptions.PatronNotFoundException;
import com.example.librarymanagmentsystem.models.patronModel.Patron;

import java.util.List;

public interface PatronService {
    Patron getPatronById(Long id) throws PatronNotFoundException;
    List<Patron> getAllPatrons();
    Patron createPatron(Patron patron);
    Patron updatePatron(Long id, Patron patron) throws PatronNotFoundException;
    void deletePatron(Long id) throws PatronNotFoundException;
}
