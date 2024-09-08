package com.gauravCoding.learnAvro;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void userTest(){
        User user = new User();
        user.setName("Gaurav");
        user.setFavoriteColor("Blue");
        user.setFavoriteNumber(7);

        System.out.println(String.format("User: %s", user));
    }
}
