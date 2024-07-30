package com.ra.user_post.versioning;

public class Name 
{

    private String fname;
    private String lname;
    public Name(String f, String l)
    {
        fname=f;
        lname=l;
    }

    public String getFname()
    {
        return fname;
    }

    public String getLname()
    {
        return lname;
    }

    public String toString()
    {
        return "First name my my "+fname+". Last name my my "+lname;
    }


}
