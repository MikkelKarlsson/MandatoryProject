package com.example.msk.service;

import com.example.msk.model.Car;
import com.example.msk.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public boolean create(Car car) {
        carRepository.create(car);
        return true;
    }

    public List<Car> fetchAll() {
        return carRepository.fetchAll();
    }


    public Boolean deleteReservation(int id) {
        return carRepository.deleteCar(id);
    }

    /*public Car updateReservation(int id, Car car) {
        return carRepository.updateCar(id, car);

    }*/

    public Car fetchById(int id) {
        return carRepository.fetchById(id);
    }
}



