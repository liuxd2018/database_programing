package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.util.HashSet;
import java.util.Set;

@Data
public class Book {
    @Id
    private Long id;
    private String isbn;
    private String title;
    private Set<AuthorRef> authors = new HashSet<>();
    public void addAuthor(Author author) {
        this.authors.add(new AuthorRef(author.getId()));
    }
}
