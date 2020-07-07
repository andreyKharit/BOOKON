/*
 * Last updated: 7/7/20, 7:52 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.repositories;

import com.itacademy.ankhar.entities.Request;
import com.itacademy.ankhar.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface RequestRepository extends CrudRepository<Request, Long> {
    @Override
    @Transactional
    <S extends Request> S save(S s);

    @Override
    Optional<Request> findById(Long id);

    Optional<Request> findByUser(User user);

    @Override
    Iterable<Request> findAll();

    @Override
    @Transactional
    void deleteById(Long id);

    @Override
    boolean existsById(Long id);
}
