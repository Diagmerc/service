package ru.lozovoi.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.lozovoi.service.domain.Car;

import java.util.List;

@Transactional(readOnly = true)
public interface CarDAO extends JpaRepository<Car, Long> {
    @Query("SELECT c FROM Car c WHERE c.user.id =:userId")
    List<Car> findAllById(@Param("userId")Long id);

    @Query("SELECT c FROM Car c WHERE c.id =:Id")
    Car getCar(@Param("Id") Long id);
}
