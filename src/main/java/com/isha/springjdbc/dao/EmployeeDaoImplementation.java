package com.isha.springjdbc.dao;

import com.isha.springjdbc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository("dao")
public class EmployeeDaoImplementation implements IEmployeeDao
{
    // DataSource = connection factory managed by Spring (with pooling)
    // details in application.properties
    @Autowired
    private DataSource dataSource;

    private String SQL_QUERY="SELECT * FROM Employee";

    @Override
    public List<Employee> getEmployeeInfo()
    {
        List<Employee> employeeList = new ArrayList<>();

        try
        {
            Connection connection= dataSource.getConnection();

            PreparedStatement pstmnt=connection.prepareStatement(SQL_QUERY);

            ResultSet resultSet=pstmnt.executeQuery();

            while(resultSet.next())
            {
                Employee employee = new Employee();

                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setCity(resultSet.getString("city"));

                employeeList.add(employee);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return employeeList;
    }
}
