package com.ra.user_post.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

//import jakarta.persistence.criteria.Predicate;

@Component
public class UserDaoService 
{
    private static int usersCount=0;

    private static List<User> users= new ArrayList<>();

    static 
    {
        users.add(new User(++usersCount,"Taylor Swift",LocalDate.now().minusYears(35)));
        users.add(new User(++usersCount,"Ariana Grande",LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount,"Zendaya",LocalDate.now().minusYears(28)));
    }

    public List<User> findAll()
    {
        return users;
    }

    public User findOne(int id) 
    {
        Predicate<? super User> predicate = user -> user.getId().equals(id); 
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
    
    public User save(User user)
    {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public void deleteById(int id) 
    {
        Predicate<? super User> predicate = user -> user.getId().equals(id); 
        users.removeIf(predicate);
        
    }
    
}
