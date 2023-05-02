package ru.lozovoi.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")
public class ViewsController {

    @GetMapping()
    public String getCars(){
        return "mycars";
    }
}
