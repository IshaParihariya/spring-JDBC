package com.isha.springjdbc.dao;

import com.isha.springjdbc.model.Employee;

import java.util.List;

public interface IEmployeeDao
{
    List<Employee> getEmployeeInfo();
}
