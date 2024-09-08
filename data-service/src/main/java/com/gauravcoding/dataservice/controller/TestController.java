package com.gauravcoding.dataservice.controller;

import com.gauravcoding.dataservice.dto.Greeting;
import com.gauravcoding.dataservice.dto.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@RequestMapping("api/v1/")
@RestController
public class TestController {

//        public final PersonService personService;
//
//        @Autowired
//        public PersonController(PersonService personService){
//            this.personService = personService;
//        }
//
//        @PostMapping
//        public void addPerson(@RequestBody Person person){
//            personService.addPerson(person);
//        }

        @GetMapping("greet")
        public String greet(){
            return "Hey from Data Service!";
        }


}
