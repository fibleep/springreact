package com.book.springreact.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="owner")
    private Set<Owner> owners;
    private String brand,model,color,registerNumber;
    private int price;

    private int release_year;

    public Car(Set<Owner> owners, String brand, String model, String color, String registerNumber, int price, int release_year) {
        this.owners = owners;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.price = price;
        this.release_year = release_year;
    }
}
