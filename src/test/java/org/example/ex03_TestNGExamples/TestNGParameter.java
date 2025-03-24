package org.example.ex03_TestNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameter {
    @Parameters("browser")
    @Test
    public void TestNgEx(String value){
        System.out.println("Browser"+value);

        if(value.equalsIgnoreCase("chrome")){
            System.out.println("Start testing");
        }
        if(value.equalsIgnoreCase("firefox")){
            System.out.println("Start firefox testing");
        }


    }
}
