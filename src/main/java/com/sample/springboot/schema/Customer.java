package com.sample.springboot.schema;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Customer {
    long custId;
    String name;
    int age;
}