package com.ob.ejercicio2;

import org.junit.jupiter.api.Test;

//@SpringBootTest
class Ejercicio2ApplicationTests {

    @Test
    void contextLoads() {
        System.getenv().forEach(
                (key, value) -> System.out.println(key + " " + value));
    }
}
