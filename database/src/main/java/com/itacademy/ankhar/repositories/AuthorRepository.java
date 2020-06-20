/*
 * Last updated: 6/3/20, 4:31 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.repositories;

import com.itacademy.ankhar.entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    @Override
    @Transactional
    <S extends Author> S save(S s);

    @Override
    Optional<Author> findById(Long id);

    Optional<Author> findByNameIgnoreCase(String name);

    @Override
    Iterable<Author> findAll();

    @Override
    @Transactional
    void deleteById(Long id);

    @Override
    boolean existsById(Long id);

    boolean existsByName(String name);
}
