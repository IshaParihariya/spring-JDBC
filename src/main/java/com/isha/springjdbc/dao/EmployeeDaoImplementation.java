package com.isha.springjdbc.dao;

import com.isha.springjdbc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@Repository("dao")
public class EmployeeDaoImplementation implements IEmployeeDao
{
    // DataSource = connection factory managed by Spring (with pooling)
    // details in application.properties
    @Autowired
    private DataSource dataSource;

    private String SQL_QUERY="SELECT * FROM Employees";

    @Override
    public List<Employee> getEmployeeInfo()
    {

        try
        {
            Connection connection= dataSource.getConnection();

            PreparedStatement pstmnt=connection.prepareStatement(SQL_QUERY);

            ResultSet rs=pstmnt.executeQuery();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
