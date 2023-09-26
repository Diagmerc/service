package ru.lozovoi.service.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.lozovoi.service.dao.UserDAO;
import ru.lozovoi.service.domain.Car;
import ru.lozovoi.service.domain.User;
import ru.lozovoi.service.service.CarService;

import java.security.Principal;
import java.util.Optional;

@Controller
public class CarController {
    private final CarService carService;

    private final UserDAO userDAO;

    public CarController(CarService carService, UserDAO userDAO) {
        this.carService = carService;
        this.userDAO = userDAO;
    }

    @GetMapping("/cars")
    public String getAll(Model model, Principal principal) {
        Long id = getId(principal).getId();
        model.addAttribute("car", carService.getCar(id));
        return "mycars";
    }

    @GetMapping("/cars/carForm")
    public String showAddForm(Car car) {
        return "car-form";
    }

    @PostMapping(value = "/cars")
    public String create(@Valid Car car, Principal principal) {
//        if (result.hasErrors()) {
//            return "record-form";
//        }
        car.setUser(getId(principal));
        carService.create(car);

        return "redirect:/cars";
    }

    private User getId(Principal principal) {
        Optional<User> byUsername = userDAO.findByUsername(principal.getName());
        return byUsername.get();
    }
}
