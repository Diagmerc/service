package ru.lozovoi.service.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.lozovoi.service.dao.UserDAO;
import ru.lozovoi.service.domain.User;
import ru.lozovoi.service.security.UserDetailsImpl;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userDAO.findByUsername(username);

        if (user.isEmpty())
            throw new UsernameNotFoundException("User not found!");
        return new UserDetailsImpl(user.get());
    }
}
