/*
 * Last updated: 6/2/20, 11:27 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.repositories;

import com.itacademy.ankhar.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    @Transactional
    <S extends Book> S save(S s);

    @Override
    Optional<Book> findById(Long id);

    Optional<Book> findByName(String name);

    @Override
    Iterable<Book> findAll();

    @Override
    @Transactional
    void deleteById(Long id);

    @Override
    boolean existsById(Long id);

    boolean existsByName(String name);
}
