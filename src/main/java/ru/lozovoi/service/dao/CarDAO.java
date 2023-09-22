package ru.lozovoi.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.lozovoi.service.domain.Car;

@Transactional(readOnly = true)
public interface CarDAO extends JpaRepository<Car, Long> {
}
