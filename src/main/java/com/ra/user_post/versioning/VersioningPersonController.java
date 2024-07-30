package com.ra.user_post.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController 
{

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson()
    {
        return new PersonV1("Little Mix");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson()
    {
        return new PersonV2(new Name("Max","Black"));
    }


    @GetMapping(path="/person", params="version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter()
    {
        return new PersonV1("Little Mix");
    }

    @GetMapping(path="/person", params="version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter()
    {
        return new PersonV2(new Name("Max","Black"));
    }


    @GetMapping(path="/person/header", headers ="X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader()
    {
        return new PersonV1("Little Mixxxxx");
    }

    @GetMapping(path="/person/header", headers ="X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader()
    {
        return new PersonV2(new Name("Han","Channing"));
    }

    @GetMapping(path="/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonAcceptHeader()
    {
        return new PersonV1("Peter Parker");
    }

    @GetMapping(path="/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeader()
    {
        return new PersonV2(new Name("Loaded","Diper"));
    }

    
}