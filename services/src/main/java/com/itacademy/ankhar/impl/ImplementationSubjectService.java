/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.impl;

import com.itacademy.ankhar.entities.Book;
import com.itacademy.ankhar.entities.Request;
import com.itacademy.ankhar.entities.User;
import com.itacademy.ankhar.interfaces.ISubjectService;
import com.itacademy.ankhar.repositories.BookRepository;
import com.itacademy.ankhar.repositories.RequestRepository;
import com.itacademy.ankhar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ImplementationSubjectService implements ISubjectService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private RequestRepository requestRepository;

    @Override
    public List<User> getSubjects() {
        final List<User> userList = new LinkedList<>();
        userRepository.findAll().iterator().forEachRemaining(userList::add);
        return userList;
    }

    @Override
    public User getUserByName(String username) {
        return userRepository.findByUserName(username).orElse(null);
    }

    @Override
    public User getSubjectById(Long id) {
        return userRepository.findById(id).orElseGet(null);
    }

    @Override
    public boolean deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return true;
    }

    @Override
    public boolean updateUserStatus(Long userId, String status) {
        User user = userRepository.findById(userId).orElseGet(User::new);
        if (user != null) {
            user.setUserStatus(status);
            userRepository.save(user);
            return true;
        }
        else return false;
    }

    @Override
    public Request getUserRequest(String userName) {
        User user = userRepository.findByUserName(userName).orElseGet(User::new);
        return requestRepository.findByUser(user).orElseGet(Request::new);
    }

    @Override
    public List<Request> getAllRequests() {
        final List<Request> requestList = new LinkedList<>();
        requestRepository.findAll().iterator().forEachRemaining(requestList::add);
        return requestList;
    }

    @Override
    public void saveRequest(Long id, Long bookId, String userName, String status) {
        Request request;
        if (id!=null) {
            request = requestRepository.findById(id).orElseGet(Request::new);
        } else {
            request = new Request();
        }
        request.setType(status);
        request.setUser(userRepository.findByUserName(userName).orElseGet(User::new));
        Book book = bookRepository.findById(bookId).orElseGet(Book::new);
        book.setBookStatus(0);
        bookRepository.save(book);
        request.setBook(bookRepository.findById(bookId).orElseGet(Book::new));
        requestRepository.save(request);
    }

    @Override
    public void deleteRequest(Long id) {
        Request request = requestRepository.findById(id).orElseGet(Request::new);
        Book book = request.getBook();
        book.setBookStatus(1);
        bookRepository.save(book);
        requestRepository.deleteById(id);
    }
}
