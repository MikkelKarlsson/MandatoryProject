package com.example.msk.service;

import com.example.msk.model.Car;
import com.example.msk.model.Person;
import com.example.msk.repository.CarRepository;
import com.example.msk.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public boolean create(Person person) {
        personRepository.create(person);
        return true;
    }

    public List<Person> fetchAll() {
        return personRepository.fetchAll();
    }


    /*public Boolean deletePerson(int id) {
        return personRepository.deleteCar(id);
    }*/

    /*public Car updatePerson(int id, Car car) {
        return carRepository.updateCar(id, car);

    }*/

    public Person fetchById(int id) {
        return personRepository.fetchById(id);
    }

}
