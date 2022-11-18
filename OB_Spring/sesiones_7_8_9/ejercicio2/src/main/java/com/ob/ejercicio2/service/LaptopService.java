package com.ob.ejercicio2.service;

import com.ob.ejercicio2.entity.Laptop;
import com.ob.ejercicio2.repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService implements ILaptopService {

    private final Logger log = LoggerFactory.getLogger(LaptopService.class);

    @Autowired
    private LaptopRepository laptopRepository;

    @Override
    public List<Laptop> findAll() {
        log.info("REST Request for finding all devices");
        if (laptopRepository.findAll().isEmpty()) {
            log.warn("No devices found");
        }
        return laptopRepository.findAll();
    }

    @Override
    public Optional<Laptop> findOneById(Long id) {
        log.info("REST Request for finding a laptop by id: {}", id);
        if (!laptopRepository.existsById(id)) {
            log.warn("There is no device with id: {}", id);
        }
        return laptopRepository.findById(id);
    }

    public Boolean existsById(Long id) {
        return laptopRepository.existsById(id);
    }

    @Override
    public Laptop create(Laptop laptop) {
        log.info("REST Request for creating a laptop");
        Laptop result = null;
        return laptopRepository.save(laptop);
    }

    @Override
    public Laptop update(Laptop laptop) {
        log.info("REST Request for updating a laptop");
        return laptopRepository.save(laptop);
    }

    @Override
    public void deleteOneById(Long id) {
        log.info("REST Request for deletion one laptop by id");
        laptopRepository.deleteById(id);
        System.out.println("Laptop with id: " + id + " was deleted succesfully.");
    }

    @Override
    public void deleteAll() {
        if (laptopRepository.findAll().isEmpty()) {
            log.warn("There is no laptops for deletion");
        } else {
            log.info("REST Request for deletion all devices");
            laptopRepository.deleteAll();
            System.out.println("All laptops were deleted successfully.");
        }
    }
}
