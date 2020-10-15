package com.example.msk.repository;

import com.example.msk.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    @Autowired
    JdbcTemplate template;


    public List<Person> fetchAll() {
        String sql = "SELECT * FROM person";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        return template.query(sql, rowMapper);
    }

    public void create(Person person) {
        String sql = "INSERT INTO person (first_name, last_name) VALUES(?, ?)";
        template.update(sql, person.getFirstName(), person.getLastName());
    }

    /*public boolean deleteCar(int id){
        String sql = "DELETE FROM person WHERE id = ?";
        return template.update(sql, id) > 0;
    }*/

    /*public Car updateCar(int id, Car car){
        String sql = "UPDATE car SET brand=?, model=?, registraion=? WHERE id=?";
        template.update(sql, car.getBrand(), car.getModel(), car.getRegistration());
        return null;
    }*/

    public Person fetchById(int id) {
        String sql = "SELECT * FROM person WHERE Id=?";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        Person person = template.queryForObject(sql, rowMapper, id);
        return person;
    }
}
