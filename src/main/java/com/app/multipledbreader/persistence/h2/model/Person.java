package com.app.multipledbreader.persistence.h2.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;
}
