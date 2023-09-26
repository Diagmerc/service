package ru.lozovoi.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.lozovoi.service.domain.Car;
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

    @GetMapping("/record")
    public String getAllrecords(Model model, @RequestBody Car car) {
        Long id = car.getId();
        model.addAttribute("record", recordService.recordsList(car.getId()));
        return "records";
    }
    @GetMapping("/place")
    public String getPlaceView() {
        return "place";
    }
}
