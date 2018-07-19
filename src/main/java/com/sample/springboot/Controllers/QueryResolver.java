package com.sample.springboot.Controllers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class QueryResolver implements GraphQLQueryResolver {

    public String getData(){
        return "This is a sample string";
    }

   /* public User[] getUsers(){

    }*/

}
