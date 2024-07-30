package com.ra.user_post.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


@Entity(name="user_details")
public class User 
{

    

    //protected User()
    //{

    //}

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2, message = "Minimum length of name should be 2.")
    //@JsonProperty("user_name")
    private String name;

    @Past(message = "The birthdate should be in the past.")
    //@JsonProperty("birth_date")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;

    public User(Integer id, String n, LocalDate bd)
    {
        super();
        this.id=id;
        name=n;
        birthDate=bd;
    }


    public User()
    {
        id=0;
        name="";
        birthDate=null;

    }


    public Integer getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    public void setName(String n)
    {
        name=n;
    }
    public void setId(Integer id)
    {
        this.id=id;
    }
    public void setBirthDate(LocalDate bd)
    {
        birthDate=bd;
    }

    public List<Post> getPosts()
    {
        return posts;
    }

    public void setPosts(List<Post> posts)
    {
        this.posts=posts;
    }

    public String toString()
    {
        return "My name is: "+name+", id number "+id+". Iwas born in "+birthDate;
    }
    
}
