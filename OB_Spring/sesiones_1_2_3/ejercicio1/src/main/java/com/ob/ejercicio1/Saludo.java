package com.ob.ejercicio1;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Saludo {

    Scanner sc = new Scanner(System.in);

    public Saludo() {
        System.out.println("Ejecutando constructor Saludo");
    }

    public String imprimirSaludo() {

        System.out.println("¿Cómo te llamas?");
        String nombre = sc.nextLine();
        return "Buenos días " + nombre + "!";
    }
}
