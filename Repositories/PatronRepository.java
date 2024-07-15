package com.example.librarymanagmentsystem.Repositories;

import com.example.librarymanagmentsystem.models.patronModel.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Long> {
    @Override
    List<Patron> findAll();
    Patron findByPatronID(Long id);
    Patron save(Patron patron);
    void delete(Patron patron);
}
