/*
 * Last updated: 6/3/20, 4:38 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.repositories;

import com.itacademy.ankhar.Book;
import com.itacademy.ankhar.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    @Override
    @Transactional
    <S extends Publisher> S save(S s);

    @Override
    Optional<Publisher> findById(Long id);

    Optional<Publisher> findByPublisherName(String name);

    @Override
    Iterable<Publisher> findAll();

    @Override
    @Transactional
    void deleteById(Long id);

    @Override
    boolean existsById(Long id);

    boolean existsByPublisherName(String name);
}
