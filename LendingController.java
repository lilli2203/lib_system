package com.example.librarymanagmentsystem.Controllers;

import com.example.librarymanagmentsystem.models.lendingModel.Lending;
import com.example.librarymanagmentsystem.models.lendingModel.LendingStatus;
import com.example.librarymanagmentsystem.dtos.LendingDTO;
import com.example.librarymanagmentsystem.services.lendingService.LendingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

//import java.util.Date;
import java.util.*;
import java.util.Date;

@RestController
@RequestMapping("/lending")
public class LendingController {
    LendingService lendingService;
    LendingController(LendingService lendingService) {
        this.lendingService = lendingService;
    }

    //  Get Lending by ID
    @GetMapping("/{id}")
    public Lending getLendingById(@PathVariable("id") Long id) {
        return lendingService.getLendingById(id);
    }

    // Get Lending by Patron ID
    @GetMapping("patron/{patronId}")
    public List<Lending> getLendingByPatronId(@PathVariable("patronId") Long patronId) {
        return lendingService.getLendingByPatronId(patronId);
    }

    // Get Lending by Book ID
    @GetMapping("book/{bookTitle}")
    public List<Lending> getLendingByBookTitle(@PathVariable("bookTitle") String bookTitle) {
        return lendingService.getLendingByBookTitle(bookTitle);
    }

    // Get Lending by Date
    @GetMapping("lendingDate/{date}")
    public List<Lending> getLendingByDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date date) {
        return lendingService.getLendingByLendingDate(date);
    }

    // Get Lending by Due Date
    @GetMapping("dueDate/{dueDate}")
    public List<Lending> getLendingByDueDate(@PathVariable("dueDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date dueDate) {
        return lendingService.getLendingByDueDate(dueDate);
    }

    // Get Lending by Lending Status
    @GetMapping("status/{status}")
    public List<Lending> getLendingByStatus(@PathVariable("status") LendingStatus status) {
        return lendingService.getLendingByStatus(status);
    }

    //  Get all Lending
    @GetMapping
    public List<Lending> getAllLendings() {
        return lendingService.getAllLendings();
    }

    //  Create a Lending
    @PostMapping
    public Lending createLending(@RequestBody LendingDTO lending) {
        return lendingService.createLending(lending);
    }

    //  Update a Lending
    @PutMapping("/{lendingId}")
    public Lending updateLending(@PathVariable("lendingId") Long lendingId, @RequestBody LendingDTO lendingDTO) {
        return lendingService.updateLending(lendingId, lendingDTO);
    }

    //  Delete a Lending
    @DeleteMapping("/{lendingId}")
    public void deleteLending(@PathVariable("lendingId") Long lendingId) {
        lendingService.deleteLending(lendingId);
    }
}
