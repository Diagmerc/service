package ru.lozovoi.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.lozovoi.service.domain.User;

@Transactional(readOnly = true)
public interface UserDAO extends JpaRepository<User, Integer> {
}
