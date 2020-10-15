package com.example.msk.service;

import com.example.msk.model.CarCollectorGroup;
import com.example.msk.model.Person;
import com.example.msk.repository.CarCollectorGroupRepository;
import com.example.msk.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarCollectorGroupService {

    @Autowired
    CarCollectorGroupRepository carCollectorGroupRepository;

    /*public boolean create(Car car) {
        carRepository.create(car);
        return true;
    }*/

    public List<CarCollectorGroup> fetchAll() {
        return carCollectorGroupRepository.fetchAll();
    }


    /*public Boolean deletePerson(int id) {
        return personRepository.deleteCar(id);
    }*/

    /*public Car updatePerson(int id, Car car) {
        return carRepository.updateCar(id, car);

    }*/

    public CarCollectorGroup fetchById(int id) {
        return carCollectorGroupRepository.fetchById(id);
    }

}
