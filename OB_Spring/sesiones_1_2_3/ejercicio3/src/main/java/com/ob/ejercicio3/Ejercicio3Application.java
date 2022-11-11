package com.ob.ejercicio3;

import com.ob.ejercicio3.model.Employee;
import com.ob.ejercicio3.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio3Application {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Ejercicio3Application.class, args);

        EmployeeRepository repository = context.getBean(EmployeeRepository.class);

        Employee ona = new Employee(null, "Ona", "Garniu", "123456789A", "ona@ona.com", 612345678);
        Employee kalatrava = new Employee(null, "Kalatrava", "Garniu", "987654321B", "kalatrava@kalatrava.com", 698765432);
        Employee kai = new Employee(null, "Kai", "Garniu", "999999999C", "kai@kai.com", 666666666);
        repository.save(ona);
        repository.save(kalatrava);
        repository.save(kai);

        System.out.println(repository.findById(2L));
        System.out.println("El número actual de empleados es: " + repository.count());

        System.out.println("Listado de empleados: ");
        for (Employee employee : repository.findAll()) {
            System.out.println(employee);
        }
    }
}
