package com.ra.user_post.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController 
{
    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource)
    {
        this.messageSource=messageSource;
    }

    //@RequestMapping(method= RequestMethod.GET, path="/hello-world")
    @GetMapping(path="/hello-world")
    public String helloWorld()
    {
        return "Hold up I am serious";
    }

    //returns in json format
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean()
    {
        return new HelloWorldBean("Hello hey");
    }

    @GetMapping(path="/hello-world-path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
    {
        return new HelloWorldBean("How you doing, "+name+"?");
    }

    @GetMapping(path="/hello-world-international")
    public String helloWorldInternational()
    {

        Locale locale= LocaleContextHolder.getLocale();

        return messageSource.getMessage("good.mo.message", null, "default", locale);
         
    }

    
}
