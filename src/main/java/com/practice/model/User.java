package com.practice.model;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Introspected
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @NotBlank
    @Column
    private String name;
    @NotBlank
    @Column
    private String mobileNumber;
    @NotBlank
    @Column
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
