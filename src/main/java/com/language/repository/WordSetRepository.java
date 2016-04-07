package com.language.repository;

import com.language.domain.WordSet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by user on 17.12.15.
 */
@Repository
public interface WordSetRepository extends CrudRepository<WordSet, Long> {

    List<WordSet> findByUserId(Long userId);

    List<WordSet> findByName(String name);

}
