package com.example.librarymanagmentsystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
    private long id;
    private String name;
    private String dob;
    private String nationality;
    private String biography;
    private List<BookDTO> books;    
    private String placeOfBirth;
    private String email;
    private String website;
    private List<String> awards;
    private List<String> genres;
    private int numberOfBooksPublished;
    private String education;
    private List<String> notableWorks;
    private String literaryStyle;
    private List<String> influences;
    private String careerStart;
    private String careerHighlights;
    private String photoUrl;

    public AuthorDTO(long id, String name, String dob, String nationality, String biography) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.nationality = nationality;
        this.biography = biography;
    }

    public void addBook(BookDTO book) {
        this.books.add(book);
    }

    public void removeBook(BookDTO book) {
        this.books.remove(book);
    }

    public void addAward(String award) {
        this.awards.add(award);
    }

    public void removeAward(String award) {
        this.awards.remove(award);
    }

    public void addGenre(String genre) {
        this.genres.add(genre);
    }

    public void removeGenre(String genre) {
        this.genres.remove(genre);
    }

    public void addNotableWork(String work) {
        this.notableWorks.add(work);
    }

    public void removeNotableWork(String work) {
        this.notableWorks.remove(work);
    }

    public void addInfluence(String influence) {
        this.influences.add(influence);
    }

    public void removeInfluence(String influence) {
        this.influences.remove(influence);
    }

    public String getFullDetails() {
        return "AuthorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", nationality='" + nationality + '\'' +
                ", biography='" + biography + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", numberOfBooksPublished=" + numberOfBooksPublished +
                ", education='" + education + '\'' +
                ", literaryStyle='" + literaryStyle + '\'' +
                ", careerStart='" + careerStart + '\'' +
                ", careerHighlights='" + careerHighlights + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", awards=" + awards +
                ", genres=" + genres +
                ", notableWorks=" + notableWorks +
                ", influences=" + influences +
                ", books=" + books +
                '}';
    }
}
