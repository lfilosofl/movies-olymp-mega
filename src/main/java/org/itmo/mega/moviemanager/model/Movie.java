package org.itmo.mega.moviemanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100)
    @NotNull(message = "Field 'title' is required")
    @Size(max = 100, message = "Field 'title' should be not longer than 100 symbols")
    private String title;

    @Column(nullable = false)
    @NotNull(message = "Field 'year' is required")
    @Min(value = 1900, message = "Field 'year' should be more then 1900")
    @Max(value = 2100, message = "Field 'year' should be less then 2100")
    private int year;

    @JoinColumn(nullable = false)
    @ManyToOne
    @NotNull(message = "Field 'director' is required")
    private Director director;

    @Column(nullable = false)
    @NotNull(message = "Field 'length' is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss")
    private Date length;

    @Column(nullable = false)
    @NotNull(message = "Field 'rating' is required")
    @Min(value = 0, message = "Field 'rating' should be more then 0")
    @Max(value = 10, message = "Field 'rating' should be less then 10")
    private int rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Date getLength() {
        return length;
    }

    public void setLength(Date length) {
        this.length = length;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
