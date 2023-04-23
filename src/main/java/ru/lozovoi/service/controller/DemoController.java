package ru.lozovoi.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lozovoi.service.service.UserService;


@RestController
public class DemoController {

    private final UserService userService;

    public DemoController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public String forAdmin() {
        return "Admin OK";
    }

    @GetMapping("/user")
    public String forUser() {
        return "User OK";
    }

}
