package ru.lozovoi.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lozovoi.service.dao.UserDAO;
import ru.lozovoi.service.service.UserService;

import java.security.Principal;


@RestController
public class DemoController {

    private final UserService userService;

    private final UserDAO userDAO;

    public DemoController(UserService userService, UserDAO userDAO) {
        this.userService = userService;
        this.userDAO = userDAO;
    }

    @GetMapping("/users")
    public String forAdmin(Principal principal) {
        String name = principal.getName();
        return name + " ok ";
    }

    @GetMapping("/user")
    public String forUser() {
        return "User OK";
    }

}
