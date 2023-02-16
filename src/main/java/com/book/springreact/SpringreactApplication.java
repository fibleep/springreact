package com.book.springreact;

import com.book.springreact.domain.Car;
import com.book.springreact.domain.Owner;
import com.book.springreact.persistance.CarRepository;
import com.book.springreact.persistance.OwnerRepository;
import com.book.springreact.persistance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.book.springreact.domain.User;

import java.util.Set;

@SpringBootApplication
public class SpringreactApplication {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(SpringreactApplication.class, args);
    }
@Bean
    CommandLineRunner runner(){
        return args -> {
          // Demo data
            Owner owner1 = new Owner("Filip","Nowak");
            Owner owner2 = new Owner("Marcel","Nowak");
            ownerRepository.save(owner1);
            ownerRepository.save(owner2);
            Car car1 = new Car(Set.of(owner1),"Ford","Mustang","Red","ADF-1121",2017,5900);
            Car car2 = new Car(Set.of(owner2),"Nissan","Leaf","White","SSJ-3002",2014,29000);
            carRepository.save(car1);
            carRepository.save(car2);
            User user1 = new User("user1","$2a$10$Q8Z", "USER");
            User user2 = new User("user2","$2a$10$Q8Z", "ADMIN");
            userRepository.save(user1);
            userRepository.save(user2);
        };
}
}
