package com.sample.springboot.Controllers;

import com.sample.springboot.dao.CustomerDAO;
import com.sample.springboot.schema.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerClass {

    @Value("${hello.message:test}")
    private String helloMessage;

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getStringResponse(){
        return "Sample String Response";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String dataInsert(){
        try{
            customerDAO.insert(new Customer(1, "Utkarsh", 25));
            return "success";
        }catch(Exception e){
            return "failure";
        }
    }


}
