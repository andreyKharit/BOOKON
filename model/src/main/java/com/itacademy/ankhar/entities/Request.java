/*
 * Last updated: 6/11/20, 10:53 PM
 * Author: Andrey Kharitonenko
 */

/*
 * Last updated: 4/6/20, 4:56 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.entities;

import javax.persistence.*;

@Entity (name = "request")
@Table(name = "ankhar_requests")
public class Request {
    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;
    @OneToOne
    private Book book;
    @Column(name = "request_type")
    private String type;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
