package com.example.librarymanagmentsystem.dtos;

import com.example.librarymanagmentsystem.models.bookModel.Genre;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private long authorId;
    private Genre genre;
    private Date publicationDate;
    private String ISBN;
    private String language;
    private int pageCount;
    private String publisher;
    private String edition;
    private String format;
    private String description;
    private List<String> keywords;
    private double rating;
    private int numberOfRatings;
    private String coverImageUrl;
    private List<ReviewDTO> reviews;
    public BookDTO(long id, String title, long authorId, Genre genre, Date publicationDate, String ISBN, String language) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.genre = genre;
        this.publicationDate = publicationDate;
        this.ISBN = ISBN;
        this.language = language;
    }

    public void addKeyword(String keyword) {
        this.keywords.add(keyword);
    }

    public void removeKeyword(String keyword) {
        this.keywords.remove(keyword);
    }

    public void addReview(ReviewDTO review) {
        this.reviews.add(review);
    }

    public void removeReview(ReviewDTO review) {
        this.reviews.remove(review);
    }

    public String getFullDetails() {
        return "BookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorId=" + authorId +
                ", genre=" + genre +
                ", publicationDate=" + publicationDate +
                ", ISBN='" + ISBN + '\'' +
                ", language='" + language + '\'' +
                ", pageCount=" + pageCount +
                ", publisher='" + publisher + '\'' +
                ", edition='" + edition + '\'' +
                ", format='" + format + '\'' +
                ", description='" + description + '\'' +
                ", keywords=" + keywords +
                ", rating=" + rating +
                ", numberOfRatings=" + numberOfRatings +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class ReviewDTO {
    private long id;
    private long bookId;
    private String reviewerName;
    private String reviewText;
    private Date reviewDate;
    private int rating;
}
