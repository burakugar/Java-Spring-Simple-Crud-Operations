package com.example.demo1.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="employees") // employee sütunu map edildi
public class Employee {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // primary keyin generate edilme yöntemini belirliyor
    private long id;
    @Column(name= "first_name",nullable = false)
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;

}
