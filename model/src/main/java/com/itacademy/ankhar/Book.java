/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity(name = "book")
@Table(name = "ankhar_books")
@Component
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue
    private Long id;
    @Column(name = "book_name", nullable = false)
    private String name;
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,
            targetEntity = Author.class, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private Author bkAuthor;

    @PrePersist
    void prePersist() {
        if (this.bookStatus == null) {
            this.bookStatus = 1;
        }
    }

    @Column(name = "book_status", nullable = false)
    private Integer bookStatus;
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, targetEntity = Publisher.class,
    optional = false)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher bkPublisher;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ankhar_books_genres",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    public Long getId() {
        return id;
    }

    public void setId(Long bookId) {
        this.id = bookId;
    }

    public Author getBkAuthor() {
        return bkAuthor;
    }

    public void setBkAuthor(Author author) {
        this.bkAuthor = author;
    }

    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Publisher getBkPublisher() {
        return bkPublisher;
    }

    public void setBkPublisher(Publisher publisher) {
        this.bkPublisher = publisher;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
