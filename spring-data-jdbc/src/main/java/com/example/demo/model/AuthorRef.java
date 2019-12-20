package com.example.demo.model;

import lombok.Data;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;

@Table("book_author")
@Data
public class AuthorRef implements AggregateReference<Author, Long> {

    private Long author;

    public AuthorRef(Long author) {
        this.author = author;
    }

    @Override
    public Long getId() {
        return this.author;
    }
}
