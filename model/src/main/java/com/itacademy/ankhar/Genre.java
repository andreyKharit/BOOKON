/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "genre")
@Table(name = "ankhar_genres")
public class Genre {
    @Id
    @Column(name = "genre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "genre_name", unique = true, nullable = false)
    private String genreName;
    @ManyToMany
    @JoinTable(name = "ankhar_books_genres",
    joinColumns = @JoinColumn(name = "genre_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> book = new HashSet<>();

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long genreId) {
        this.id = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
