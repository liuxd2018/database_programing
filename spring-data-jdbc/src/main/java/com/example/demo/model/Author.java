package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class Author {
    @Id
    private Long id;
    private String name;
    private LocalDate birthDate;
    private Set<BookRef> books = new HashSet<>();

    public void addBook(Book book) {
        this.books.add(new BookRef(book.getId()));
    }


}
