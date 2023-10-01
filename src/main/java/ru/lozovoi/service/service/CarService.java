package ru.lozovoi.service.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lozovoi.service.dao.CarDAO;
import ru.lozovoi.service.domain.Car;

import java.util.List;

@Service
public class CarService {

    private final CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public List<Car> getCars(Long id) {
        return carDAO.findAllById(id);
    }

    public Car getCar(Long id) {
        return carDAO.getById(id);
    }

    public List<Car> getAllCar(){
        return carDAO.findAll();
    }

    @Transactional
    public Car create(Car car) {
        return carDAO.save(car);
    }
}
