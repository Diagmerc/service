package ru.lozovoi.service.service;

import org.springframework.stereotype.Service;
import ru.lozovoi.service.dao.UserDAO;
import ru.lozovoi.service.domain.User;

import java.util.List;

@Service
public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getAll(){
        return userDAO.findAll();
    }
}
