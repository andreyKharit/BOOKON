/*
 * Last updated: 4/6/20, 4:56 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import javax.persistence.*;

@Entity (name = "request")
@Table(name = "ankhar_requests")
public class Request {
    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
