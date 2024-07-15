package com.example.librarymanagmentsystem.services.lendingService;

import com.example.librarymanagmentsystem.models.lendingModel.Lending;
import com.example.librarymanagmentsystem.models.lendingModel.LendingStatus;
import com.example.librarymanagmentsystem.dtos.LendingDTO;
import com.example.librarymanagmentsystem.exceptions.lendingexceptions.LendingHistoryNotFoundException;

import java.util.Date;
import java.util.List;

public interface LendingService {
    Lending getLendingById(Long id) throws LendingHistoryNotFoundException;

    List<Lending> getAllLendings();

    Lending createLending(LendingDTO lendingDTO);

    Lending updateLending(Long id, LendingDTO lendingDTO) throws LendingHistoryNotFoundException;

    void deleteLending(Long id) throws LendingHistoryNotFoundException;

    List<Lending> getLendingByPatronId(Long id);
    List<Lending> getLendingByBookTitle(String title);

    List<Lending> getLendingByLendingDate(Date date);

    List<Lending> getLendingByDueDate(Date dueDate);

    List<Lending> getLendingByStatus(LendingStatus status);
}
