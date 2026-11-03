package com.workintech.s18d4.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="first_name")
    private String firstName;
    @NotNull
    @Column(name="last_name")
    private String lastName;

    @NotNull
    @Email
    @Column(name="email")
    private String email;

    @NotNull
    @Column(name="salary")
    private Double salary;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address;
    @JsonManagedReference
    @OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
    private List<Account> accounts = new ArrayList<>();

}
