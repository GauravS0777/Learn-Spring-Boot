package com.gauravCoding.restApiExample.service;

import com.gauravCoding.restApiExample.dao.PersonDao;
import com.gauravCoding.restApiExample.module.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("personMemoryDao") PersonDao personDao){
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.addPerson(person);
    }

    public List<Person> getPersonsList(){
        return personDao.getPersonsList();
    }
}
