package ru.lozovoi.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lozovoi.service.domain.User;
import ru.lozovoi.service.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class DemoController {

    private final UserService userService;

    public DemoController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping
    public String testSecurity() {
        return "OK";
    }

}
