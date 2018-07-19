package com.sample.springboot.dao;

import com.sample.springboot.schema.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerDAO /*extends JdbcDaoSupport*/{

   /* @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }*/

   @Autowired
   private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void insert(Customer cus) {
        String sql = "INSERT INTO customer " +
                "(CUST_ID, NAME, AGE) VALUES (:id, :name, :age)" ;
        Map<String, Object> map = new HashMap<>();
        map.put("id", cus.getCustId());
        map.put("name", cus.getName());
        map.put("age", cus.getAge());

        /*getJdbcTemplate().update(sql, new Object[]{
                cus.getCustId(), cus.getName(), cus.getAge()
        });*/
        namedParameterJdbcTemplate.update(sql,map);
        System.out.println("DB Insertiom success");
    }
}