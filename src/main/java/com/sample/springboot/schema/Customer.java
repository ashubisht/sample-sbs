package com.sample.springboot.schema;

import lombok.Data;

import java.io.Serializable;

@Data
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    long custId;
    String name;
    int age;
}