package ru.lozovoi.service.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lozovoi.service.dao.CarDAO;
import ru.lozovoi.service.domain.Car;

import java.util.Collections;
import java.util.List;

@Service
public class CarService {

    CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public List<Car> getCar(Long id) {
        return carDAO.findAllById(id);
    }

    @Transactional
    public Car create(Car car) {
        return carDAO.save(car);
    }
}
