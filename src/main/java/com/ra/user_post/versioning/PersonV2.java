package com.ra.user_post.versioning;

public class PersonV2 
{
    private Name name;
    public PersonV2(Name n)
    {
        name=n;
    }
    public Name getName()
    {
        return name;
    }

    public String toString()
    {
        return "The name is "+name;
    }

}
