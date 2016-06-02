package com.language.web;

import com.language.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by user on 16.04.16.
 */
@Controller
public class HomeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    protected static final String PATH_ROOT = "/home";


    @Autowired
    private UserRepository userRepository;

    @RequestMapping(PATH_ROOT)
    public String getHomePage(Model model) {
        LOGGER.debug("Getting home page");
        return "home";
    }

}
