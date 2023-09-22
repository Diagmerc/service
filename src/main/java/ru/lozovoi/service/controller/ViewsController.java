package ru.lozovoi.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.lozovoi.service.service.CarService;
import ru.lozovoi.service.service.RecordService;

@Controller
public class ViewsController {

    private final RecordService recordService;

    private final CarService carService;

    public ViewsController(RecordService recordService, CarService carService) {
        this.recordService = recordService;
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getAll(Model model) {
        model.addAttribute("car", carService.getCar());
        return "mycars";
    }

    @GetMapping("/record")
    public String getAllrecords(Model model) {
        model.addAttribute("record", recordService.recordsList());
        return "records";
    }
}
