package com.ra.user_post.helloworld;

public class HelloWorldBean 
{
    private String message;
    public HelloWorldBean(String message)
    {
        this.message =message ;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message=message;
    }

    public String toString()
    {
        return "Everyone be greeting me with "+message ;
    }

}
