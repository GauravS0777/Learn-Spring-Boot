package com.gauravcoding.learnstream;

import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<String> list = List.of("Gaurav", "Shivi", "Koala", "Panda");
        list.forEach(System.out::println);
    }
}
