package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Employee {
    @Id
    private Long id;
    private String name;
    private Long department;

    public void setDepartment(Department department) {
        this.department = department.getId();
    }
}
