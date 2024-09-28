package org.jeeva.tests;


import org.jeeva.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;


public final class LoginPageTests extends BaseTest{

    // 1. Never HardCode

    // Class or interface name - JeevaArumugam
    // final constant values --> JEEVAARUMUGAM or JEEVA_ARUMUGAM
    // method name --> jeevaArumugam
    // package --> jeevaarumugam

    private LoginPageTests(){

    }

    @Test
    public void test1()   {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);

    }

    @Test
    public void test2()   {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);

    }



}
