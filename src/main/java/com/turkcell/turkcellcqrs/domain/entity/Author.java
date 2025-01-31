package com.turkcell.turkcellcqrs.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.validator.constraints.UUID;

import java.util.Set;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @UuidGenerator
    private UUID id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    @OneToMany(mappedBy = "author")
    private Set<Book> books;
}
