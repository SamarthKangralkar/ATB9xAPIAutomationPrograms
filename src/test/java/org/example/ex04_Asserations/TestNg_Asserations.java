package org.example.ex04_Asserations;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNg_Asserations {
    @Description("")
    @Test
    public  void tng_asserations(){
        Boolean is_neeru_male=false;
        Assert.assertTrue(is_neeru_male);
        System.out.println("It wont execute if hard asseration fails");


    }
    @Test
    public  void tng_soft_asserations(){
        Boolean is_neeru_male=false;
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(is_neeru_male);

        System.out.println("Softasset will be executed even if asseration is fail");
        softAssert.assertAll();
    }
}
