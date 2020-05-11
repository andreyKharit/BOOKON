/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "author")
@Table(name = "ankhar_authors", uniqueConstraints = @UniqueConstraint(columnNames = {"author_id", "author_name"}))
public class Author {
    @Id
    @Column(name = "author_id")
    @GeneratedValue
    private Long authorId;
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

    public Long getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthorId(Long id) {
        this.authorId = id;
    }
}

