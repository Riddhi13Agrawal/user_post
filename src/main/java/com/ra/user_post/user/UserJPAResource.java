package com.ra.user_post.user;



import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

//import org.apache.el.stream.Optional;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ra.user_post.jpa.PostRepository;
import com.ra.user_post.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJPAResource 
{
    

    private UserRepository userRepository;

    private PostRepository postRepository;


    public UserJPAResource(UserRepository repository,  PostRepository postRepository)
    {
        
        this.userRepository=repository;
        this.postRepository=postRepository;
    }


    @GetMapping(path="/jpa/users")
    public List<User> retrieveAllUsers()
    {
        return userRepository.findAll(); 
    }

    @GetMapping(path="/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable Integer id)
    {
        Optional<User> user= userRepository.findById(id);

        if(user.isEmpty())
            throw new UserNotFoundException(id+" id made it to the Lost and Never Found Box.");
        EntityModel<User> entityModel= EntityModel.of(user.get());

        WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).retrieveAllUsers());

        entityModel.add(link.withRel("all-users"));

        return entityModel; 
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser( @Valid @RequestBody User user)
    {
        User savedUser=userRepository.save(user);

        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @DeleteMapping(path="/jpa/users/{id}")
    public void deleteUser(@PathVariable Integer id)
    {
        userRepository.deleteById(id);

        
    }

    @GetMapping(path="/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable Integer id)
    {
        //repository.deleteById(id);

        Optional<User> user= userRepository.findById(id);

        if(user.isEmpty())
            throw new UserNotFoundException(id+" id made it to the Lost and Never Found Box.");
        
        return user.get().getPosts();
        
        
    }


    @PostMapping(path="/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostsForUser(@PathVariable Integer id, @Valid @RequestBody Post post )
    {
        //repository.deleteById(id);

        Optional<User> user= userRepository.findById(id);

        if(user.isEmpty())
            throw new UserNotFoundException(id+" id made it to the Lost and Never Found Box.");
        
        
        post.setUser(user.get());
        Post savedPost= postRepository.save(post);
       

        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId()).toUri();

        return ResponseEntity.created(location).build();
        
        
    }


    
}
