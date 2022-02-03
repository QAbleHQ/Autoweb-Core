package io.unity.autoweb;

import org.testng.Reporter;

public class testng_logs {



    public void test_step(String message)
    {
        System.out.println(message);
        Reporter.log(message +"<br>");
    }








}
