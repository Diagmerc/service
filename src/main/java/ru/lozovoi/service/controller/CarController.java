package ru.lozovoi.service.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
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

    @GetMapping("/cars/carForm")
    public String showAddForm(Car car) {
        return "car-form";
    }

    @PostMapping(value = "/cars")
    public String create(@Valid Car car, Principal principal) {
//        if (result.hasErrors()) {
//            return "record-form";
//        }
        Optional<User> byUsername = userDAO.findByUsername(principal.getName());
        Long id = byUsername.get().getCars().stream().findFirst().get().getId();
        car.setUser_id(Math.toIntExact(id));
        carService.create(car);

        return "redirect:/cars";
    }
}
