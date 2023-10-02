package ru.lozovoi.service.repository;

import org.springframework.stereotype.Repository;
import ru.lozovoi.service.dao.RecordDAO;
import ru.lozovoi.service.domain.Record;

@Repository
public class RecordRepository {

    RecordDAO recordDAO;

    public RecordRepository(RecordDAO recordDAO) {
        this.recordDAO = recordDAO;
    }

    public Record save(Record record) {
        return recordDAO.save(record);
    }

    public Record getById(Long id){
        return recordDAO.getById(Math.toIntExact(id));
    }
}
