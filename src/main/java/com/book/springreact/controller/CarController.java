package com.book.springreact.controller;

import com.book.springreact.domain.Car;
import com.book.springreact.persistance.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CarController {
    @Autowired
    private CarRepository carRepository;
    @GetMapping("/cars")
    public Iterable<Car> getCars(){
        return carRepository.findAll();
    }

}
