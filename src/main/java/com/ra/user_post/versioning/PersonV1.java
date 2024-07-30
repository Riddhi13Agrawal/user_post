package com.ra.user_post.versioning;

public class PersonV1 
{
    private String name;
    public PersonV1(String name)
    {
        super();
        this.name=name;
    }

    public void setName(String n)
    {
        name=n;
    }

    public String getName()
    {
        return name;
    }

    public String toString()
    {
        return "The name is "+name;
    }

}
