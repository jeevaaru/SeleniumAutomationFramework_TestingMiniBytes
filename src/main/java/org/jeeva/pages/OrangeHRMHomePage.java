package org.jeeva.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import org.jeeva.driver.DriverManager;
import org.jeeva.reports.ExtentLogger;
import org.jeeva.reports.ExtentManager;
import org.jeeva.reports.ExtentReport;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public final class OrangeHRMHomePage extends BasePage{

    private final By drpUserDropdown = By.className("oxd-userdropdown-name");
    private final By linkLogout = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickUserName(){
        DriverManager.getDriver().findElement(drpUserDropdown).click();
                                                                         //ExtentManager.getExtentTest().pass("Clicking on User Dropdown");
        ExtentLogger.pass("Clicking on User Dropdown");
        return this;
    }

    public OrangeHRMLoginPage clickLogout(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        DriverManager.getDriver().findElement(linkLogout).click();
                                                                      //ExtentManager.getExtentTest().pass("Clicking on Logout");
        ExtentLogger.pass("Clicking on Logout");
        return new OrangeHRMLoginPage();
    }
}
