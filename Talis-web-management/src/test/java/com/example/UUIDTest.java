package com.example;

import org.junit.jupiter.api.Test;

public class UUIDTest {


    @Test
    public void test1(){
        for (int i = 0; i < 10; i++) {
            System.out.println(java.util.UUID.randomUUID().toString());
        }
    }
}
