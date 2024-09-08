package com.gauravcoding.learnstream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DemoTest {
    @Test
    public void testHello(){
        System.out.println("Inside test hello");
        Assertions.assertTrue(true);
    }

    public static void main(String[] args){
        System.out.println("Inside demotest class main");
    }
}
