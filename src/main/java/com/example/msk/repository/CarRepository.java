package com.example.msk.repository;

import com.example.msk.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository {

    @Autowired
    JdbcTemplate template;


    public List<Car> fetchAll() {
        String sql = "SELECT * FROM car";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return template.query(sql, rowMapper);
    }

    public void create(Car car) {
        String sql = "INSERT INTO car (brand, model, registration) VALUES(?, ?, ?)";
        template.update(sql, car.getBrand(), car.getModel(), car.getRegistration());
    }

    public boolean deleteCar(int id){
        String sql = "DELETE FROM car WHERE id = ?";
        return template.update(sql, id) > 0;
    }

    /*public Car updateCar(int id, Car car){
        String sql = "UPDATE car SET brand=?, model=?, registraion=? WHERE id=?";
        template.update(sql, car.getBrand(), car.getModel(), car.getRegistration());
        return null;
    }*/

    public Car fetchById(int id) {
        String sql = "SELECT * FROM car WHERE Id=?";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        Car car = template.queryForObject(sql, rowMapper, id);
        return car;
    }
}
