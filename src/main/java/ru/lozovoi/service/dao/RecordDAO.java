package ru.lozovoi.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.lozovoi.service.domain.Record;

@Transactional(readOnly = true)
public interface RecordDAO extends JpaRepository<Record, Integer> {

}
