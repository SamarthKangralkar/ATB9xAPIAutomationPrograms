package org.example.ex03_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_Grouping {

    @Test(groups = {"QA"})
    public void TestNG1(){
        System.out.println("Hello");
        Assert.assertTrue(true);
    }
    @Test(groups = {"SDET"})
        public void TestNG2(){
            System.out.println("SDET");
            Assert.assertTrue(true);
        }
    }

