/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "publisher")
@Table(name = "ankhar_publishers")
public class Publisher {
    @Id
    @Column(name = "publisher_id")
    @GeneratedValue
    private Long id;
    @Column(name = "publisher_name", unique = true, nullable = false)
    private String publisherName;
    @OneToMany(mappedBy = "bkPublisher", fetch = FetchType.EAGER, cascade = {
            CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REMOVE
    }, orphanRemoval = true)
    private Set<Book> books = new HashSet<>();

    public Set<Book> getBooks() {
        return books;
    }

    public void addBooks(Book book) {
        book.setBkPublisher(this);
        this.books.add(book);
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long publisherId) {
        this.id = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}
