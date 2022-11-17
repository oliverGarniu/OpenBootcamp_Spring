package com.ob.ejercicio1.service;

import com.ob.ejercicio1.controller.LaptopController;
import com.ob.ejercicio1.entity.Laptop;
import com.ob.ejercicio1.repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService implements ILaptopService {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    LaptopRepository laptopRepository;

    public LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    public List<Laptop> findAll() {
        log.info("REST Request for finding all devices");
        return laptopRepository.findAll();
    }

    public Optional<Laptop> findOneById(Long id) {
        log.info("REST Request for finding a laptop by id");
        return laptopRepository.findById(id);
    }

    public Laptop create(Laptop laptop) {
        log.info("REST Request for creating a laptop");
        return laptopRepository.save(laptop);
    }

    public Laptop update(Laptop laptop) {
        log.info("REST Request for updating a laptop");
        return laptopRepository.save(laptop);
    }

    public Boolean existsById(Long id) {
        return laptopRepository.existsById(id);
    }

    public void deleteById(Long id) {
        log.info("REST Request for deletion one laptop by id");
        laptopRepository.deleteById(id);
        System.out.println("Laptop with id: " + id + " was deleted succesfully.");
    }

    public void deleteAll() {
        if (laptopRepository.findAll().isEmpty()) {
            System.out.println("There is no laptops to delete.");
        } else {
            log.info("REST Request for deletion all devices");
            laptopRepository.deleteAll();
            System.out.println("All laptops were deleted succesfully.");
        }
    }
}
