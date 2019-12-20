package com.example.demo.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Objects;

public class Pet {
    @Id
    private Long id; // todo this place must be Long not long because (2)
    private String name;
    private LocalDate birthDate;

    private type petType;

    public enum type {
        ONE, TWO
    }

    public Pet(Long id, String name, LocalDate birthDate, type petType) { // todo (1) when loading from database string became the enum
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.petType = petType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static Pet of(String name, LocalDate birthDate, type petType) { // todo (1) when loading from database string became the enum
        return new Pet(null, name, birthDate, petType); // todo (2) null of Long to create not saved instance
    } // 你好吗呵呵

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", petType=" + petType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return id.equals(pet.id) &&
                name.equals(pet.name) &&
                birthDate.equals(pet.birthDate) &&
                petType == pet.petType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, petType);
    }
}
