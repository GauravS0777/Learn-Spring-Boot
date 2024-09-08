package com.gauravCoding.restApiExample.dao;

import com.gauravCoding.restApiExample.module.Person;

import java.util.List;
import java.util.UUID;

public interface PersonDao {
    public int addPerson(String id, Person person);

    public default int addPerson(Person person){
        String id = UUID.randomUUID().toString();
        return addPerson(id, person);
    }

    public List<Person> getPersonsList();
}

