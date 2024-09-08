package com.gauravCoding.restApiExample.dao;

import com.gauravCoding.restApiExample.module.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("personMemoryDao")
public class PersonMemoryDao implements PersonDao {

  private static final List<Person> db = new ArrayList<>();

  @Override
  public int addPerson(String id, Person person) {
    db.add(Person.builder().id(id).name(person.getName()).build());
    return 1;
  }

  @Override
  public List<Person> getPersonsList() {
    return db;
  }
}
