package com.example.demo01.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //auto increment
    private Long id;

    private  String firstName;

    private  String lastName;

    @Column(nullable = false, unique = true)
    private  String email;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",
    joinColumns = {
            @JoinColumn(name = "student_id",referencedColumnName ="id" )
    },
    inverseJoinColumns = {
            @JoinColumn(name = "course_id",referencedColumnName = "id")
    }
    )
    @JsonIgnore
    private Set<Course> courses;




}
