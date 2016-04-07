package com.language.Service;

import com.language.domain.User;
import com.language.domain.UserCreateForm;

import java.util.List;

/**
 * Created by user on 16.12.15.
 */
public interface UserService {
    User getUserById(long id);
    User getUserByName(String name);
    List<User> getAllUsers();
    User create(UserCreateForm form);
    User save(User user);
    void delete(User user);



}
