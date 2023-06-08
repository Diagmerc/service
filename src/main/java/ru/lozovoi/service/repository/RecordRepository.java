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

    public Record save(Record record, long id) {
        record.setId(id);

        return recordDAO.save(record);
    }
}
