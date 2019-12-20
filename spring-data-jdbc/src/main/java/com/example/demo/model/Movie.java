package com.example.demo.model;

import org.springframework.data.annotation.Id;

import java.time.Duration;

public class Movie {
    @Id
    private Long id;
    private String title;
    private String description;
    private Rental rental;

    public Movie(Long id, String title, String description, Rental rental) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rental = rental;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rental=" + rental +
                '}';
    }

    // you need this to delete or change rental
    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public static class Rental {
        private Duration duration;
        private Integer price;

        public Rental(Duration duration, Integer price) {
            this.duration = duration;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Rental{" +
                    "duration=" + duration +
                    ", price=" + price +
                    '}';
        }
    }
}
