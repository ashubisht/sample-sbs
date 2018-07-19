package com.sample.springboot.Controllers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.sample.springboot.dao.CustomerDAO;
import com.sample.springboot.schema.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    @Autowired
    private CustomerDAO customerDAO;

    public User createUser(User userInput) {
        return customerDAO.createUser(userInput);
    }

}
