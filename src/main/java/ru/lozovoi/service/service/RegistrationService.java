package ru.lozovoi.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lozovoi.service.dao.UserDAO;
import ru.lozovoi.service.domain.Role;
import ru.lozovoi.service.domain.User;

import java.util.Collections;

@Service
public class RegistrationService {

    private final UserDAO userDAO;

    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public RegistrationService(UserDAO userDAO, BCryptPasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(User user) {
        user.setRole("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.save(user);
    }
}
