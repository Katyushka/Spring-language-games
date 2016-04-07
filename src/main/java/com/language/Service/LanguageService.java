package com.language.Service;

import com.language.domain.Language;
import com.language.domain.LanguageCreateForm;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user on 17.12.15.
 */

public interface LanguageService {

    //List<Languages> findByUsersId(List<Long> usersId);

    Language findById(Long id);

    List<Language> getAllLanguages();

    Language getLanguageById(Long id);

    Language create(LanguageCreateForm form);

    Language save(Language presentation);

    void delete(Language presentation);

}
