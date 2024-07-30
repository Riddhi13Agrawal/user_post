package com.ra.user_post.exception;

//import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails 
{
    private LocalDateTime timestamp;
    private String message;
    private String details;

    ErrorDetails(LocalDateTime timestamp, String message, String details)
    {
        super();
        this.timestamp= timestamp;
        this.message= message;
        this.details= details;

    }

    public void setTimestamp(LocalDateTime timestamp)
    {
        this.timestamp= timestamp;
        
    }

    public LocalDateTime getTimestamp()
    {
        return timestamp;
    }

    public void setMessage(String message)
    {
        this.message= message;
        
    }
    public String getMessage()
    {
        return message;
    }
    public void setDetails(String details)
    {
        this.details= details;
    }
    public String getDetails()
    {
        return details;
    }

    public String toString()
    {
        return "Time : "+ timestamp + " Message : "+ message +" Details : "+details;
    }

    
}
