package com.language.repository;

import com.language.domain.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by user on 17.12.15.
 */

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
    //List<Languages> findByUsersIn(Collection<User> users);

   // List<Language> findByUsersIdIn(Collection<Long> id);

}
