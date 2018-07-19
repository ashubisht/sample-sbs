package com.sample.springboot.Controllers;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Temporary commented because unable to resolve classpath
//@PropertySource("classpath:sample.properties") //Optional if property file is in classpath. Useful is external file
@Component //Need to add if main class uses ComponentScan
@ConfigurationProperties
public class ConfigurableClass {
    private String email;

    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public String getEmail(){
        return email;
    }

}
