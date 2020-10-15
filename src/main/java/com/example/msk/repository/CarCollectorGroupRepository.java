package com.example.msk.repository;


import com.example.msk.model.CarCollectorGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CarCollectorGroupRepository {

    @Autowired
    JdbcTemplate template;


    public List<CarCollectorGroup> fetchAll() {
        String sql = "SELECT * FROM carCollectorGroup";
        RowMapper<CarCollectorGroup> rowMapper = new BeanPropertyRowMapper<>(CarCollectorGroup.class);
        return template.query(sql, rowMapper);
    }

    /*public void create(Car car) {
        String sql = "INSERT INTO car (brand, model, registraion) VALUES(?, ?, ?)";
        template.update(sql, car.getBrand(), car.getModel(), car.getRegistration());
    }*/

    /*public boolean deleteCar(int id){
        String sql = "DELETE FROM person WHERE id = ?";
        return template.update(sql, id) > 0;
    }*/

    /*public Car updateCar(int id, Car car){
        String sql = "UPDATE car SET brand=?, model=?, registraion=? WHERE id=?";
        template.update(sql, car.getBrand(), car.getModel(), car.getRegistration());
        return null;
    }*/

    public CarCollectorGroup fetchById(int id) {
        String sql = "SELECT * FROM person WHERE Id=?";
        RowMapper<CarCollectorGroup> rowMapper = new BeanPropertyRowMapper<>(CarCollectorGroup.class);
        CarCollectorGroup carCollectorGroup = template.queryForObject(sql, rowMapper, id);
        return carCollectorGroup;
    }

}
