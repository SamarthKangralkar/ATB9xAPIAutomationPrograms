package org.example.ex03_TestNGExamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample1 {
    @AfterTest
    public void Test3(){
        System.out.println("Runining after the test2 class");
    }
    @Test
    public void Test2(){
        System.out.println("Running after Hello1 & Hello2");
    }
    @BeforeTest
    public void Test(){
        System.out.println("Hello1");
    }
    @BeforeTest
    public void Testt(){
        System.out.println("Hello2");
    }
    @Test(priority = 1)
    public void t1(){
        System.out.println("my name is okkkkk");
    }
    @Test(priority = 3)
    public void t2(){
        System.out.println("my name is kokoko");
    }
    @Test(priority = 2)
    public void t3(){
        System.out.println("mttetet");
    }


}
