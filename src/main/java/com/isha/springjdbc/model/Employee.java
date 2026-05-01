package com.isha.springjdbc.model;

public class Employee
{
    private Integer id;
    private String name;
    private String city;

    //zero parm constructor
    public Employee()
    {
        System.out.println("Zero param Constructor of Employee");
    }

    // setters and getters
    public void setId(Integer id)
    {
        this.id=id;
    }
    public void setName(String name)
    {
       this.name=name;
    }
    public void setCity(String city)
    {
       this.city=city;
    }

    public Integer getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getCity()
    {
        return city;
    }

    // parm constructor
    public Employee(Integer id, String name, String city)
    {
        this.id=id;
        this.name=name;
        this.city=city;
    }

    // to string method
    @Override
    public String toString()
    {
        return "[ id = "+id +" name = "+name +" city = "+city +" ]";
    }
}
