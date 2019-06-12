package com.example.demo.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: jorden
 * @Date: 2019/6/3 17:01
 * @Description:
 */
public class Java8Tester {
   @Test
   public void test1(){
       List names = new ArrayList();
       names.add("Google");
       names.add("Runoob");
       names.add("Taobao");
       names.add("Baidu");
       names.add("Sina");
       names.forEach(System.out::println);
   }
    @Test
    public void test2(){
       GreetingService greetingService = message -> System.out.println(message);
    }
   @FunctionalInterface
   interface GreetingService{
       void sayMessage(String message);
   }
}
