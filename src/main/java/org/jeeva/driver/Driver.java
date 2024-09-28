package org.jeeva.driver;

import org.jeeva.enums.ConfigProperties;
import org.jeeva.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.Objects;

import static org.jeeva.driver.DriverManager.getDriver;

public final class Driver {

    private Driver(){}





    public static void initDriver() throws Exception {
        if(Objects.isNull(DriverManager.getDriver())){
            WebDriver driver = new ChromeDriver();
            DriverManager.setDriver(driver);
            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        }
    }

    public static void quitDriver(){
        if(Objects.nonNull(getDriver())) {
            getDriver().quit();
            DriverManager.unload();
        }
    }
}
