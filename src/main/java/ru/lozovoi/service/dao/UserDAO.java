package ru.lozovoi.service.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.lozovoi.service.domain.User;

import java.util.Optional;

@Transactional(readOnly = true)
public interface UserDAO extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);


}
