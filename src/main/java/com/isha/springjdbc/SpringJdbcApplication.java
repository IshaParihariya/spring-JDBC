package com.isha.springjdbc;

import com.isha.springjdbc.dao.EmployeeDaoImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext container=SpringApplication.run(SpringJdbcApplication.class, args);
        EmployeeDaoImplementation dao=container.getBean(EmployeeDaoImplementation.class);
        dao.getEmployeeInfo().forEach(e->System.out.println(e));
    }

}
