package com.kevin.demo.maven;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author:Kevin
 * @Date:Created in 17:24 2021/4/10
 */
public class HelloWorldTest {

    @Test
    public void testSayHello(){
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHello();
        Assert.assertEquals("Hello Maven",result);
    }
}
