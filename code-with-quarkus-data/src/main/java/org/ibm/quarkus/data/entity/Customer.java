package org.ibm.quarkus.data.entity;


import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

//Entity + repository implementation =Active Record Pattern
@Entity
public class Customer extends PanacheEntity {
    @Column
    public String name;
    @Column
    public String city;

    public Customer() {
    }

    public Customer(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
