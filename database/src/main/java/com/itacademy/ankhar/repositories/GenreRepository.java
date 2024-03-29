/*
 * Last updated: 6/3/20, 4:35 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.repositories;

import com.itacademy.ankhar.entities.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
    @Override
    @Transactional
    <S extends Genre> S save(S s);

    @Override
    Optional<Genre> findById(Long id);

    Optional<Genre> findByGenreName(String name);

    @Override
    Iterable<Genre> findAll();

    List<Genre> findByIdIn(List<Long> genreIdList);

    @Override
    @Transactional
    void deleteById(Long id);

    @Override
    boolean existsById(Long id);

    boolean existsByGenreName(String name);
}
