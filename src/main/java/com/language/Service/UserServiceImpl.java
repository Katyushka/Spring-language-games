package com.language.Service;

import com.language.domain.Role;
import com.language.domain.User;
import com.language.domain.UserCreateForm;
import com.language.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by user on 17.12.15.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(long id) {
        LOGGER.debug("Getting user={}", id);
        return userRepository.findOne(id);
    }

    @Override
    public User getUserByLogin(String login) {
        LOGGER.debug("Getting user by name");
        return userRepository.findByLogin(login);
    }

    @Override
    public List<User> getAllUsers() {
        LOGGER.debug("Getting all users");
        List<User> users = new ArrayList<User>();
        for (User user : userRepository.findAll()) {
            users.add(user);
        }
        return users;
    }

    @Override
    public User create(UserCreateForm form) {
        LOGGER.debug("Create new user");
        User user = new User();
        user.setLogin(form.getLogin());
        user.setPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setEmail(form.getEmail());
        user.setRole(Role.ROLE_USER);
        return userRepository.save(user);
    }

    @Override
    public User save(User user) {
        LOGGER.debug("Save user");
        if (user.getId() == null) {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        }
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        LOGGER.debug("Delete user");
        userRepository.delete(user);
    }


}
