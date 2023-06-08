package ru.lozovoi.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.lozovoi.service.service.RecordService;

@Controller
public class ViewsController {

    private final RecordService recordService;

    public ViewsController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("/cars")
    public String getAll(Model model){
        model.addAttribute("record", recordService.recordsList());
        return "mycars";
    }
}
