package com.example.librarymanagmentsystem.Controllers;

import com.example.librarymanagmentsystem.models.patronModel.Patron;
import com.example.librarymanagmentsystem.services.patronService.PatronService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patron")
public class PatronController {

    private PatronService patronService;
    PatronController(PatronService patronService) {
        this.patronService = patronService;
    }

    // Get Patron by ID's
    @GetMapping("/{id}")
    public Patron getPatronById(@PathVariable("id") Long id) {
        return patronService.getPatronById(id);
    }

    //Get all Patrons
    @GetMapping
    public List<Patron> getAllPatrons() {
        return patronService.getAllPatrons();
    }

    @PostMapping
    public Patron createPatron(@RequestBody Patron patron) {
        return patronService.createPatron(patron);
    }

    // Update Patron
    @PutMapping("/{id}")
    public Patron updatePatron(@PathVariable("id") Long id, @RequestBody Patron patron) {
        return patronService.updatePatron(id, patron);
    }

    // Delete Patron
    @DeleteMapping("/{id}")
    public void deletePatron(@PathVariable("id") Long id) {
        patronService.deletePatron(id);
    }
}
