package com.miv.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "country")
    private String country;
    @Column(name = "zipcode")
    private int zipCode;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;

}
