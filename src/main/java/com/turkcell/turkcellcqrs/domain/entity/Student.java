package com.turkcell.turkcellcqrs.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Table(name = "students")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Student extends User{
    @Column(name="student_no")
    private String studentNo;

    @OneToOne(mappedBy = "student")
    private Cart cart;

    @OneToMany(mappedBy = "student")
    private Set<Order> orders;
}
