package com.appSecurity.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    @NotEmpty(message = "Name should not be empty.")
    @Size(min = 2, max = 100, message = "Name should be between 2 and 100 characters.")
    private String username;

    @Column(name = "year_of_birth")
    @Min(value = 1900, message = "Year should be more than 1900.")
    private int yearOfBirth;

    @Column(name = "password")
    private String password;

    public Person() {

    }

    public Person(String username, int yearOfBirth) {
        this.username = username;
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", password='" + password + '\'' +
                '}';
    }
}
