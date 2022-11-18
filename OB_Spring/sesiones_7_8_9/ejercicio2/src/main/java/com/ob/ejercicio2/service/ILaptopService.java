package com.ob.ejercicio2.service;

import com.ob.ejercicio2.entity.Laptop;

import java.util.List;
import java.util.Optional;

public interface ILaptopService {
    List<Laptop> findAll();
    Optional<Laptop> findOneById(Long id);
    Laptop create(Laptop laptop);
    Laptop update(Laptop laptop);
    void deleteOneById(Long id);
    void deleteAll();
}
