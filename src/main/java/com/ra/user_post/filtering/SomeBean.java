package com.ra.user_post.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//@JsonIgnoreProperties({"field1","field2"})
@JsonFilter("SomeBeanFilter")
public class SomeBean 
{

    private String field1;

    //@JsonIgnore
    private String field2;
    private String field3;

    public SomeBean(String f1, String f2, String f3)
    {
        field1=f1;
        field2=f2;
        field3=f3;
    }

    public String getField1()
    {
        return field1;
    }

    public String getField2()
    {
        return field2;
    }

    public String getField3()
    {
        return field3;
    }

    public String toString()
    {
        return " "+field1+" "+field2 + " "+ field3;
    }

}
