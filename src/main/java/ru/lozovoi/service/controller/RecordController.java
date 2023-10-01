package ru.lozovoi.service.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.lozovoi.service.dao.UserDAO;
import ru.lozovoi.service.domain.Car;
import ru.lozovoi.service.domain.Record;
import ru.lozovoi.service.repository.RecordRepository;
import ru.lozovoi.service.service.CarService;

@Slf4j
@Controller
public class RecordController {

    RecordRepository recordRepository;

    UserDAO userDAO;

    CarService carService;

    public RecordController(RecordRepository recordRepository, UserDAO userDAO, CarService carService) {
        this.recordRepository = recordRepository;
        this.userDAO = userDAO;
        this.carService = carService;
    }

    @GetMapping("/cars/recordForm/{id}")
    public String showAddForm(@ModelAttribute("record") Record record, @PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "record-form";
    }

    @PostMapping(value = "/record")
    public String create(@Valid Record record, HttpServletRequest request) {
//        if (result.hasErrors()) {
//            return "record-form";
//        }
        String id = request.getParameter("id_car");
        log.info(id);
        Car car = carService.getCar(Long.valueOf(id));
        record.setCar(car);
        recordRepository.save(record);
        return "redirect:/cars";
    }
}
