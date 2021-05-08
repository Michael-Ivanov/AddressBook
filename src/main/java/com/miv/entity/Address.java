package com.miv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "person")
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

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

}
