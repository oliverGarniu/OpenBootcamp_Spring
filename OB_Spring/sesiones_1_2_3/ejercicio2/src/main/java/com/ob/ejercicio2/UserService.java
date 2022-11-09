package com.ob.ejercicio2;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    NotificationService notificationService;

    public UserService(NotificationService notificationService) {
        System.out.println("Ejecutando constructor");
        this.notificationService = notificationService;
    }
}
