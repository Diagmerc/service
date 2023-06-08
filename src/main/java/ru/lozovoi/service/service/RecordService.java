package ru.lozovoi.service.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lozovoi.service.dao.RecordDAO;
import ru.lozovoi.service.domain.Record;

import java.util.List;

@Service
public class RecordService {
    private final RecordDAO records;

    public RecordService(RecordDAO records) {
        this.records = records;
    }

    public List<Record> recordsList() {
        return records.findAll();
    }

    @Transactional
    public Record create(Record record){
        return records.save(record);
    }

}
