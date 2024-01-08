package com.example.demo01.entity;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //auto increament
    private Long id;

    private  String firstName;

    private  String lastName;

    @Column(nullable = false, unique = true)
    private  String email;

}
