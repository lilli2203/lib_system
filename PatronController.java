package com.example.librarymanagmentsystem.Controllers;

import com.example.librarymanagmentsystem.models.patronModel.Patron;
import com.example.librarymanagmentsystem.services.patronService.PatronService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patron")
public class PatronController {

    private final PatronService patronService;

    PatronController(PatronService patronService) {
        this.patronService = patronService;
    }

    @GetMapping("/{id}")
    public Patron getPatronById(@PathVariable("id") Long id) {
        return patronService.getPatronById(id);
    }

    @GetMapping
    public List<Patron> getAllPatrons() {
        return patronService.getAllPatrons();
    }

    @PostMapping
    public Patron createPatron(@RequestBody Patron patron) {
        return patronService.createPatron(patron);
    }

    @PutMapping("/{id}")
    public Patron updatePatron(@PathVariable("id") Long id, @RequestBody Patron patron) {
        return patronService.updatePatron(id, patron);
    }

    @DeleteMapping("/{id}")
    public void deletePatron(@PathVariable("id") Long id) {
        patronService.deletePatron(id);
    }

    @GetMapping("/email/{email}")
    public Patron getPatronByEmail(@PathVariable("email") String email) {
        return patronService.getPatronByEmail(email);
    }

    @GetMapping("/name/{name}")
    public List<Patron> getPatronsByName(@PathVariable("name") String name) {
        return patronService.getPatronsByName(name);
    }

    @PutMapping("/updateAddress/{id}")
    public Patron updatePatronAddress(@PathVariable("id") Long id, @RequestBody String address) {
        return patronService.updatePatronAddress(id, address);
    }

    @PutMapping("/updatePhone/{id}")
    public Patron updatePatronPhoneNumber(@PathVariable("id") Long id, @RequestBody String phoneNumber) {
        return patronService.updatePatronPhoneNumber(id, phoneNumber);
    }

    @PutMapping("/activate/{id}")
    public Patron activatePatron(@PathVariable("id") Long id) {
        return patronService.activatePatron(id);
    }

    @PutMapping("/deactivate/{id}")
    public Patron deactivatePatron(@PathVariable("id") Long id) {
        return patronService.deactivatePatron(id);
    }

    @GetMapping("/active")
    public List<Patron> getActivePatrons() {
        return patronService.getActivePatrons();
    }

    @GetMapping("/inactive")
    public List<Patron> getInactivePatrons() {
        return patronService.getInactivePatrons();
    }

    @GetMapping("/search")
    public List<Patron> searchPatrons(@RequestParam("keyword") String keyword) {
        return patronService.searchPatrons(keyword);
    }

    @PostMapping("/batchCreate")
    public List<Patron> batchCreatePatrons(@RequestBody List<Patron> patrons) {
        return patronService.batchCreatePatrons(patrons);
    }

    @PutMapping("/batchUpdate")
    public List<Patron> batchUpdatePatrons(@RequestBody List<Patron> patrons) {
        return patronService.batchUpdatePatrons(patrons);
    }

    @DeleteMapping("/batchDelete")
    public void batchDeletePatrons(@RequestBody List<Long> patronIds) {
        patronService.batchDeletePatrons(patronIds);
    }

    @GetMapping("/export")
    public void exportPatronsToCSV() {
        patronService.exportPatronsToCSV();
    }

    @PostMapping("/import")
    public List<Patron> importPatronsFromCSV(@RequestBody String csvData) {
        return patronService.importPatronsFromCSV(csvData);
    }

    @PostMapping("/notify/{id}")
    public void sendNotificationToPatron(@PathVariable("id") Long id, @RequestBody String message) {
        patronService.sendNotificationToPatron(id, message);
    }

    @GetMapping("/overdue")
    public List<Patron> getPatronsWithOverdueBooks() {
        return patronService.getPatronsWithOverdueBooks();
    }

    @PutMapping("/assignRole/{id}")
    public Patron assignRoleToPatron(@PathVariable("id") Long id, @RequestBody String role) {
        return patronService.assignRoleToPatron(id, role);
    }
}
