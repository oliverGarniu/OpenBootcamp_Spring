package com.ob.ejercicio1.controller;

import com.ob.ejercicio1.entity.Laptop;
import com.ob.ejercicio1.service.LaptopService;
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

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    @Autowired
    LaptopService laptopService;

    /**
     * http://localhost:8080/api/laptops
     *
     * @return
     */
    @GetMapping("/laptops")
    public List<Laptop> findAll() {
        return laptopService.findAll();
    }

    @GetMapping("/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id) {
        Optional<Laptop> laptopOptional = laptopService.findOneById(id);
        if (laptopOptional.isPresent()) {
            return ResponseEntity.ok(laptopOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
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
    public ResponseEntity<Object> update(@RequestBody Laptop laptop) {
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
    public ResponseEntity<Laptop> delete(@PathVariable Long id) {
        if (!laptopService.existsById(id)) {
            log.warn("Trying to delete a non existing laptop");
            return ResponseEntity.notFound().build();
        }
        laptopService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/laptops")
    public ResponseEntity<Laptop> deleteAll() {
        laptopService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
