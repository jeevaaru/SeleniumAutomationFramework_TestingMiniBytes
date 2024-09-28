package org.jeeva.tests;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.jeeva.driver.Driver;
import org.jeeva.reports.ExtentReport;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;

import java.io.IOException;
import java.lang.reflect.Method;


public class BaseTest {

    protected BaseTest(){

    }

// use access modifer as private, if doesn't work, use protected, then default then public



    @BeforeMethod
    protected void setUp() throws Exception {

        Driver.initDriver();
    }

    @AfterMethod
    protected void tearDown() {

       Driver.quitDriver();

    }

}
