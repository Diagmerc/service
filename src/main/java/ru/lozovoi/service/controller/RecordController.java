package ru.lozovoi.service.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.lozovoi.service.dao.UserDAO;
import ru.lozovoi.service.domain.Record;
import ru.lozovoi.service.domain.User;
import ru.lozovoi.service.repository.RecordRepository;

import java.security.Principal;
import java.util.Optional;

@Controller
public class RecordController {

    RecordRepository recordRepository;

    UserDAO userDAO;

    public RecordController(RecordRepository recordRepository, UserDAO userDAO) {
        this.recordRepository = recordRepository;
        this.userDAO = userDAO;
    }

    @GetMapping("/cars/recordForm/{id}")
    public String showAddForm(Record record) {
        return "record-form";
    }

    @PostMapping(value = "/record")
    public String create(@Valid Record record, Principal principal) {
//        if (result.hasErrors()) {
//            return "record-form";
//        }
        Optional<User> byUsername = userDAO.findByUsername(principal.getName());
        Long id = byUsername.get().getCars().stream().findFirst().get().getId();
        record.setId(id);
        recordRepository.save(record);

        return "redirect:/cars";
    }
}
