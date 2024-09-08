package com.gauravCoding.restApiExample.controller;

import com.gauravCoding.restApiExample.module.Person;
import com.gauravCoding.restApiExample.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("api/v1/person")
@RestController
@Slf4j
public class PersonController {
  public final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  public void addPerson(@RequestBody Person person) {
    log.info("Person received: {}", person);
    personService.addPerson(person);
  }

  @GetMapping
  public ResponseEntity<List<Person>> getPersonsList() {
    return new ResponseEntity<>(personService.getPersonsList(), HttpStatus.OK);
  }

  @GetMapping("/exception")
  public ResponseEntity<List<Person>> throwException() {
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Response Status Exception");
  }
}
