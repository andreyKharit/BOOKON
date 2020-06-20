/*
 * Last updated: 5/26/20, 12:38 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.repositories;

import com.itacademy.ankhar.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    @Transactional
    <S extends User> S save(S s);

    @Override
    Optional<User> findById(Long id);

    Optional<User> findByUserName(String name);

    @Override
    Iterable<User> findAll();

    @Override
    @Transactional
    void deleteById(Long id);

    @Override
    boolean existsById(Long id);

    boolean existsByUserName(String name);
}
