package org.jeeva.listeners;


import org.jeeva.reports.ExtentLogger;
import org.jeeva.reports.ExtentReport;
import org.testng.*;

import java.io.IOException;
import java.util.Arrays;

public class ListenerClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite){
        try {
            ExtentReport.initReports();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void onFinish(ISuite suite){
        try {
            ExtentReport.flushReports();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(ITestResult result){

        ExtentReport.createTest(result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        ExtentLogger.pass(result.getMethod().getMethodName() +" is Passed");
    }

    @Override
    public void onTestFailure(ITestResult result){
        try {
            ExtentLogger.fail(result.getMethod().getMethodName() +" is Failed", true);
            ExtentLogger.fail(result.getThrowable().toString());
            ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onTestSkipped(ITestResult result){
        try {
            ExtentLogger.skip(result.getMethod().getMethodName() +" is Skipped", true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // For now, we are not using this
    }

    @Override
    public void onStart(ITestContext context){
        // We are having just one test in our Suite, so we are not using this as of now
    }

    @Override
    public void onFinish(ITestContext context){
        // We are having just one test in our Suite, so we are not using this as of now
    }
}
