package ru.lozovoi.service.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.lozovoi.service.domain.User;
import ru.lozovoi.service.dto.JwtRequest;
import ru.lozovoi.service.dto.JwtResponse;
import ru.lozovoi.service.exception.AppError;
import ru.lozovoi.service.security.JwtTokenUtils;
import ru.lozovoi.service.service.RegistrationService;
import ru.lozovoi.service.service.UserService;
import ru.lozovoi.service.util.UserValidator;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserValidator validator;
    private final RegistrationService registrationService;

    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    public AuthController(UserValidator validator, RegistrationService registrationService, JwtTokenUtils jwtTokenUtils, AuthenticationManager authenticationManager, UserService userService) {
        this.validator = validator;
        this.registrationService = registrationService;
        this.jwtTokenUtils = jwtTokenUtils;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        }catch (BadCredentialsException e){
            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(), "Не корректный логин или пароль"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
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
