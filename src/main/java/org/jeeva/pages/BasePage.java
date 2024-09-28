package org.jeeva.pages;

import org.jeeva.driver.DriverManager;
import org.jeeva.reports.ExtentLogger;
import org.openqa.selenium.By;


public class BasePage {

    protected void click(By by, String elementName){
        DriverManager.getDriver().findElement(by).click();
        try {
            ExtentLogger.pass(elementName + " is clicked", true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    protected void sendKeys(By by, String value, String elementName) {
        DriverManager.getDriver().findElement(by).sendKeys(value);
        try {
            ExtentLogger.pass(value + " is entered successfully in " +elementName, true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
