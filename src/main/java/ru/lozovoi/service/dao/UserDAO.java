package ru.lozovoi.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.lozovoi.service.domain.User;

import java.util.Optional;

@Transactional(readOnly = true)
public interface UserDAO extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
