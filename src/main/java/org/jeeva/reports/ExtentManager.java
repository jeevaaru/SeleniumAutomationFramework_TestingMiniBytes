package org.jeeva.reports;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class ExtentManager {
    private ExtentManager(){

    }

    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    static ExtentTest getExtentTest(){ // default -> it can be accessed only within the package -> private packages
        return extTest.get();
    }

    static void setExtentTest(ExtentTest test){
        extTest.set(test);
    }

    static void unload(){
        extTest.remove();
    }


}
