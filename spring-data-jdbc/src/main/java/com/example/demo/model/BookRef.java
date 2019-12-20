package com.example.demo.model;

import lombok.Data;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;

@Table("book_author")
@Data
public class BookRef implements AggregateReference<Book, Long> {
    private Long book;

    public BookRef(Long book) {
        this.book = book;
    }

    @Override
    public Long getId() {
        return this.book;
    }
}
