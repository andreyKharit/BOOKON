/*
 * Last updated: 6/11/20, 10:53 PM
 * Author: Andrey Kharitonenko
 */

/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "author")
@Table(name = "ankhar_authors", uniqueConstraints = @UniqueConstraint(columnNames = {"author_id", "author_name"}))
public class Author {
    @Id
    @Column(name = "author_id")
    @GeneratedValue
    private Long id;
    @Column(name = "author_name", nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "bkAuthor", fetch = FetchType.EAGER, cascade = {
            CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REMOVE
    }, orphanRemoval = true)
    private Set<Book> books = new HashSet<Book>();

    public Set<Book> getBooks() {
        if (books == null) {
            books = new HashSet<Book>();
        }
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void addBooks(Book book) {
        book.setBkAuthor(this);
        this.books.add(book);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

