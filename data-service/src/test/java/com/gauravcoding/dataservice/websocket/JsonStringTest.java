package com.gauravcoding.dataservice.websocket;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class JsonStringTest {

    @Test
    void test(){
        long a = 123;
        String b = LocalDateTime.now().toString();
        String jsonString = "{ \"x\": [{\"b\": {\"a\": " + b + "}}] }";

        Object read = JsonPath.read(jsonString, "$.x[0].b.a");

        //Assertions.assertTrue(read instanceof Long);


        List<Map<String, Object>> x = JsonPath.read(jsonString, "$.x");


        for(Map<String, Object> xItem: x){
            System.out.println(xItem);

            DocumentContext parse = JsonPath.parse(xItem);

            System.out.println(parse);

            String string = parse.jsonString();

            System.out.println(string);

            Object read1 = JsonPath.read(string, "$.b.a");

            System.out.println(read1);
    }
  }
}
