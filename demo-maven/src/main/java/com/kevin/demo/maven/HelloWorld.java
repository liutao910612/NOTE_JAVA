package com.kevin.demo.maven;

/**
 * @Author:Kevin
 * @Date:Created in 17:07 2021/4/10
 */
public class HelloWorld {

    public String sayHello(){
        return "Hello Maven";
    }

    public static void main(String[] args) {
        System.out.println(new HelloWorld().sayHello());
    }
}
