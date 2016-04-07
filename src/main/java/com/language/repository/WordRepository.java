package com.language.repository;

import com.language.domain.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 17.12.15.
 */
@Repository
public interface WordRepository extends CrudRepository<Word, Long> {


}
