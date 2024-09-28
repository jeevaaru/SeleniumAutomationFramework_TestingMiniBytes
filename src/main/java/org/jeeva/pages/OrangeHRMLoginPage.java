package org.jeeva.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import org.jeeva.driver.DriverManager;
import org.openqa.selenium.By;

import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public final class OrangeHRMLoginPage extends BasePage {

    /*
    id
    name
    classname
    linktext
    partial link text
    css or xpath
     */

    private final By textboxUsername = By.xpath("//input[@name='username']");
    private final By textboxPassword = By.xpath("//input[@type='password']");
    private final By btnLogin = By.xpath("//button[@type='submit']");

    public OrangeHRMLoginPage enterUsername(String username)  {

        Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
        sendKeys(textboxUsername, username, "Username");
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password)  {
        sendKeys(textboxPassword, password, "Password");
        return this;
    }

    public OrangeHRMHomePage clickLogin()  {
       click(btnLogin, "Login Button");
        Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
        return new OrangeHRMHomePage();
    }

    public void verifyLogout(){
        Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
        boolean foo = DriverManager.getDriver().findElement(textboxUsername).isDisplayed();
        Assert.assertTrue(foo);
    }


}
