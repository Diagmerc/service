package ru.lozovoi.service.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lozovoi.service.dao.UserDAO;
import ru.lozovoi.service.domain.User;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format("User not '%s' found", username)));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), Collections.singleton(new SimpleGrantedAuthority(user.getRole()))
        );
    }

    public List<User> getAll() {
        return (List<User>) userDAO.findAll();
    }
}
