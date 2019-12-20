package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public final class Hobbit {
    private final String name;
    private final Address address;
    private final List<String> stuff;

    // all args constructor with deep copy
    public Hobbit(String name, Address address, List<String> stuff) {
        this.name = name;
        this.address = new Address(address.getCountry(), address.getCity());
        this.stuff = new ArrayList<>(stuff);
    }
    // getters with deep copy
    public String getName() {
        return name;
    }

    public Address getAddress() {
        return new Address(address.getCountry(), address.getCity());
    }

    public List<String> getStuff() {
        return new ArrayList<>(stuff);
    }
}
