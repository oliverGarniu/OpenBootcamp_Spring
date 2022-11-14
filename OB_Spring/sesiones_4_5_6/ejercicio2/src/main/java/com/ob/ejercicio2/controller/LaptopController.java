package com.ob.ejercicio2.controller;

import com.ob.ejercicio2.entity.Laptop;
import com.ob.ejercicio2.repository.LaptopRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LaptopController {

    LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    /**
     * http://localhost:8080/api/laptops
     *
     * @return
     */
    @GetMapping("/laptops")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }
}
