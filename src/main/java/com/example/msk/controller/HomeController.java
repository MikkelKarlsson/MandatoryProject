package com.example.msk.controller;


import com.example.msk.model.Car;
import com.example.msk.model.Person;
import com.example.msk.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CarService carService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/viewpage")
    public String viewpage(Model model){
        List<Car> carList = carService.fetchAll();
        model.addAttribute("cars", carList);
        return "viewpage";
    }

    @PostMapping("/viewpage")
    public String viewpage(@ModelAttribute Car car, Model model){
        List<Car> carList = carService.fetchAll();
        model.addAttribute("cars", carList);
        return "viewpage";
    }

    /*@PostMapping("/createcar")
    public String createcar(@ModelAttribute Car car, Model model){
            carService.create(car);
        return "createcar";
    }

    @GetMapping("/createcar/{id})
    public String createcar(@PathVariable("id"), Model model){
        carService.create(car);
        return "createcar";
    }*/

    @GetMapping("/createcar")
    public String createcar(Model model) {
        List<Car> carList = carService.fetchAll();
        model.addAttribute("cars", carList);
        return "/createcar";
    }

    @PostMapping("/createcar")
    public String createcar(@ModelAttribute Car car) {
        carService.create(car);
        return "redirect:/viewpage";
    }

    /*@GetMapping("/createperson")
    public String createperson(Model model) {
        List<Person> personList = personService.fetchAll();
        model.addAttribute("persons", personList);
        return "/createperson";
    }

    @PostMapping("/createperson")
    public String createperson(@ModelAttribute Person person) {
        personService.create(person);
        return "redirect:/viewpage";
    }*/





}
