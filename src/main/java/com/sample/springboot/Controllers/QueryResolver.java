package com.sample.springboot.Controllers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.sample.springboot.schema.Gender;
import com.sample.springboot.schema.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    public String getData(){
        return "This is a sample string";
    }

    public List<User> getUsers(){
        User user = new User();
        user.setAge(25);
        user.setEmail("id@host.com");
        user.setFirstName("Utkarsh");
        user.setId(1);
        user.setLastName("Bisht");
        user.setGender(Gender.male);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        return userList;
    }

}
