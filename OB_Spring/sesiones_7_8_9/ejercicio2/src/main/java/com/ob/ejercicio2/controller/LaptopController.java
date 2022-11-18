package com.ob.ejercicio2.controller;

import com.ob.ejercicio2.entity.Laptop;
import com.ob.ejercicio2.service.LaptopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LaptopController {

    Logger log = LoggerFactory.getLogger(LaptopController.class);

    @Autowired
    private LaptopService laptopService;

    @GetMapping("/laptops")
    public ResponseEntity<List<Laptop>> findAll() {
        List<Laptop> laptops = laptopService.findAll();
        if (laptops.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(laptops);
    }

    @GetMapping("/laptops/{id}")
    public ResponseEntity<Optional<Laptop>> findOneById(@PathVariable Long id) {
        Optional<Laptop> laptop = laptopService.findOneById(id);
        if (laptop.isPresent()) {
            return ResponseEntity.ok(laptop);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop) {
        if (laptop.getId() != null) {
            log.warn("Trying to create a Laptop with id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopService.create(laptop);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
        if (laptop.getId() == null) {
            log.warn("Trying to update a non existing laptop");
            return ResponseEntity.badRequest().build();
        }
        if (!laptopService.existsById(laptop.getId())) {
            log.warn("Trying to update a non existing laptop");
            return ResponseEntity.notFound().build();
        }
        Laptop result = laptopService.update(laptop);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/laptops/{id}")
    public ResponseEntity<Laptop> deleteOneById(@PathVariable Long id) {
        laptopService.deleteOneById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/laptops")
    public ResponseEntity<Laptop> deleteAll() {
        if(laptopService.findAll().isEmpty()){
            return ResponseEntity.notFound().build();
        }
        laptopService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
