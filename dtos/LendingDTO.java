package com.example.librarymanagmentsystem.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import com.example.librarymanagmentsystem.models.lendingModel.LendingStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LendingDTO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lendingID;
    private String bookTitle;
    private Long patronID;
    private Date dateBorrowed;
    private Date dueDate;
    private Date dateReturned;
    private LendingStatus lendingStatus;
    private String patronName;
    private String bookISBN;
    private String patronEmail;
    private String lendingRemarks;
    private int overdueDays;
    private double overdueFees;
    private String librarianName;
    private String librarianID;

    public LendingDTO(Long lendingID, String bookTitle, Long patronID, Date dateBorrowed, Date dueDate, Date dateReturned, LendingStatus lendingStatus) {
        this.lendingID = lendingID;
        this.bookTitle = bookTitle;
        this.patronID = patronID;
        this.dateBorrowed = dateBorrowed;
        this.dueDate = dueDate;
        this.dateReturned = dateReturned;
        this.lendingStatus = lendingStatus;
    }

    public void addRemarks(String remarks) {
        this.lendingRemarks = remarks;
    }

    public void calculateOverdueFees(double dailyFee) {
        if (this.dateReturned != null && this.dueDate != null && this.dateReturned.after(this.dueDate)) {
            long diffInMillies = Math.abs(this.dateReturned.getTime() - this.dueDate.getTime());
            this.overdueDays = (int) (diffInMillies / (1000 * 60 * 60 * 24));
            this.overdueFees = this.overdueDays * dailyFee;
        } else {
            this.overdueDays = 0;
            this.overdueFees = 0.0;
        }
    }

    public String getFullDetails() {
        return "LendingDTO{" +
                "lendingID=" + lendingID +
                ", bookTitle='" + bookTitle + '\'' +
                ", patronID=" + patronID +
                ", dateBorrowed=" + dateBorrowed +
                ", dueDate=" + dueDate +
                ", dateReturned=" + dateReturned +
                ", lendingStatus=" + lendingStatus +
                ", patronName='" + patronName + '\'' +
                ", bookISBN='" + bookISBN + '\'' +
                ", patronEmail='" + patronEmail + '\'' +
                ", lendingRemarks='" + lendingRemarks + '\'' +
                ", overdueDays=" + overdueDays +
                ", overdueFees=" + overdueFees +
                ", librarianName='" + librarianName + '\'' +
                ", librarianID='" + librarianID + '\'' +
                '}';
    }

    public static LendingDTO fromLending(Lending lending) {
        LendingDTO dto = new LendingDTO();
        dto.setLendingID(lending.getLendingID());
        dto.setBookTitle(lending.getBookTitle());
        dto.setPatronID(lending.getPatronID());
        dto.setDateBorrowed(lending.getDateBorrowed());
        dto.setDueDate(lending.getDueDate());
        dto.setDateReturned(lending.getDateReturned());
        dto.setLendingStatus(lending.getLendingStatus());
        return dto;
    }

    public LendingDTO(Long lendingID, String bookTitle, Long patronID, Date dateBorrowed, Date dueDate, Date dateReturned, LendingStatus lendingStatus, String patronName, String bookISBN, String patronEmail, String lendingRemarks, int overdueDays, double overdueFees, String librarianName, String librarianID) {
        this.lendingID = lendingID;
        this.bookTitle = bookTitle;
        this.patronID = patronID;
        this.dateBorrowed = dateBorrowed;
        this.dueDate = dueDate;
        this.dateReturned = dateReturned;
        this.lendingStatus = lendingStatus;
        this.patronName = patronName;
        this.bookISBN = bookISBN;
        this.patronEmail = patronEmail;
        this.lendingRemarks = lendingRemarks;
        this.overdueDays = overdueDays;
        this.overdueFees = overdueFees;
        this.librarianName = librarianName;
        this.librarianID = librarianID;
    }
}
