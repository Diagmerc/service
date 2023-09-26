package ru.lozovoi.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.lozovoi.service.domain.Car;
import ru.lozovoi.service.domain.Record;

import java.util.List;

@Transactional(readOnly = true)
public interface RecordDAO extends JpaRepository<Record, Integer> {
    @Query("SELECT r FROM Record r WHERE r.car.id =:carId")
    List<Record> findAllById(@Param("carId")Long id);
}
