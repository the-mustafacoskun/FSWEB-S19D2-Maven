package com.workintech.s18d4.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="address",schema="bank")
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="street")
    @NotNull
    private String street;
    @NotNull
    @Column(name="no")
    private Integer no;
    @Column(name="city")
    @NotNull
    private String city;
    @NotNull
    @Column(name="country")
    private String country;

    @Column(name="description")
    private String description;

    @OneToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST})
    private Customer customer;
}
