package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Department {
    @Id
    private Long id;
    private String name;
}
