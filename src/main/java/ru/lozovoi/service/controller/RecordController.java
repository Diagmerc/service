package ru.lozovoi.service.controller;

import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.lozovoi.service.domain.Record;
import ru.lozovoi.service.repository.RecordRepository;
import ru.lozovoi.service.security.AuthUser;

@Controller
public class RecordController {

    RecordRepository recordRepository;

    public RecordController(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @GetMapping("/cars/recordForm")
    public String showAddForm(Record record) {
        return "record-form";
    }

    @PostMapping(value = "/record")
    public String create(@Valid Record record, BindingResult result, Model model, @AuthenticationPrincipal AuthUser authUser) {
//        if (result.hasErrors()) {
//            return "record-form";
//        }
        long id = authUser.id();

        recordRepository.save(record, id);

        return "redirect:/cars";
    }
}
