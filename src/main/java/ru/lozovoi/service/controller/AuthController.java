package ru.lozovoi.service.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.lozovoi.service.domain.User;
import ru.lozovoi.service.service.RegistrationService;
import ru.lozovoi.service.util.UserValidator;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserValidator validator;
    private final RegistrationService registrationService;

    @Autowired
    public AuthController(UserValidator validator, RegistrationService registrationService) {
        this.validator = validator;
        this.registrationService = registrationService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user){
        return "/auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        validator.validate(user, bindingResult);
        if(bindingResult.hasErrors())
            return "auth/registration";
        registrationService.register(user);
        return "redirect:/auth/login";
    }
}
