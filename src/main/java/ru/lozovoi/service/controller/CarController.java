package ru.lozovoi.service.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        Optional<User> byUsername = getUser(principal);
        if (byUsername.get().getRole().equals("ROLE_ADMIN")) {
            model.addAttribute("car", carService.getAllCar());
        } else {
            Long id = byUsername.get().getId();
            model.addAttribute("car", carService.getCars(id));
        }
        return "mycars";
    }

    @GetMapping("/car/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Car car = carService.getCar(id);
        model.addAttribute("car", car);
        return "car-form";
    }

    @GetMapping("/car/delete/{id}")
    public String deleteRecord(@PathVariable Long id) {
        carService.deleteCar(Long.valueOf(id));
        return "redirect:/cars";
    }

    private Optional<User> getUser(Principal principal) {
        Optional<User> byUsername = userDAO.findByUsername(principal.getName());
        return byUsername;
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
        car.setUser(getUser(principal).get());
        carService.create(car);

        return "redirect:/cars";
    }
}
