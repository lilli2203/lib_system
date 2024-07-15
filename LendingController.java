package com.example.librarymanagmentsystem.Controllers;

import com.example.librarymanagmentsystem.models.lendingModel.Lending;
import com.example.librarymanagmentsystem.models.lendingModel.LendingStatus;
import com.example.librarymanagmentsystem.dtos.LendingDTO;
import com.example.librarymanagmentsystem.services.lendingService.LendingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/lending")
public class LendingController {
    LendingService lendingService;

    LendingController(LendingService lendingService) {
        this.lendingService = lendingService;
    }

    @GetMapping("/{id}")
    public Lending getLendingById(@PathVariable("id") Long id) {
        return lendingService.getLendingById(id);
    }

    @GetMapping("/patron/{patronId}")
    public List<Lending> getLendingByPatronId(@PathVariable("patronId") Long patronId) {
        return lendingService.getLendingByPatronId(patronId);
    }

    @GetMapping("/book/{bookTitle}")
    public List<Lending> getLendingByBookTitle(@PathVariable("bookTitle") String bookTitle) {
        return lendingService.getLendingByBookTitle(bookTitle);
    }

    @GetMapping("/lendingDate/{date}")
    public List<Lending> getLendingByDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date date) {
        return lendingService.getLendingByLendingDate(date);
    }

    @GetMapping("/dueDate/{dueDate}")
    public List<Lending> getLendingByDueDate(@PathVariable("dueDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date dueDate) {
        return lendingService.getLendingByDueDate(dueDate);
    }

    @GetMapping("/status/{status}")
    public List<Lending> getLendingByStatus(@PathVariable("status") LendingStatus status) {
        return lendingService.getLendingByStatus(status);
    }

    @GetMapping
    public List<Lending> getAllLendings() {
        return lendingService.getAllLendings();
    }

    @PostMapping
    public Lending createLending(@RequestBody LendingDTO lending) {
        return lendingService.createLending(lending);
    }

    @PutMapping("/{lendingId}")
    public Lending updateLending(@PathVariable("lendingId") Long lendingId, @RequestBody LendingDTO lendingDTO) {
        return lendingService.updateLending(lendingId, lendingDTO);
    }

    @DeleteMapping("/{lendingId}")
    public void deleteLending(@PathVariable("lendingId") Long lendingId) {
        lendingService.deleteLending(lendingId);
    }

    @GetMapping("/isbn/{isbn}")
    public List<Lending> getLendingByBookIsbn(@PathVariable("isbn") String isbn) {
        return lendingService.getLendingByBookIsbn(isbn);
    }

    @GetMapping("/patron/name/{name}")
    public List<Lending> getLendingByPatronName(@PathVariable("name") String name) {
        return lendingService.getLendingByPatronName(name);
    }

    @PutMapping("/extend/{lendingId}")
    public Lending extendDueDate(@PathVariable("lendingId") Long lendingId, @RequestParam("days") int days) {
        return lendingService.extendDueDate(lendingId, days);
    }

    @GetMapping("/dateRange")
    public List<Lending> getLendingByDateRange(
        @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
        @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return lendingService.getLendingByDateRange(startDate, endDate);
    }

    @GetMapping("/overdue")
    public List<Lending> getOverdueLendings() {
        return lendingService.getOverdueLendings();
    }

    @PostMapping("/notifyOverdue")
    public void notifyOverduePatrons() {
        lendingService.notifyOverduePatrons();
    }

    @PutMapping("/return/{lendingId}")
    public Lending returnBook(@PathVariable("lendingId") Long lendingId) {
        return lendingService.returnBook(lendingId);
    }

    @GetMapping("/search")
    public List<Lending> searchLendings(@RequestParam("keyword") String keyword) {
        return lendingService.searchLendings(keyword);
    }
}
