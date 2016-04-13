package com.language.repository;

/**
 * Created by user on 17.12.15.
 */

import com.language.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByLogin(String login);

    User findById(Long id);

}