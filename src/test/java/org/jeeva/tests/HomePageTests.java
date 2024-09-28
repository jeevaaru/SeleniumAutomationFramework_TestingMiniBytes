package org.jeeva.tests;


import static org.assertj.core.api.Assertions.*;
import org.jeeva.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;


public final class HomePageTests extends BaseTest{

    private HomePageTests(){

    }

    /*
    Validate whether the tile is containing Google Search
    Validate whether the title is not null and length of title is greater than 15 and less than 100
    Check for the links in the pages --> Testing mini bytes - youtube
    number of links displayed is exactly 10 or 15
     */
    @Test
    public void test3()   {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - youtube", Keys.ENTER);
        String title = DriverManager.getDriver().getTitle();


        assertThat(title) //Assertions.assertThat --> static import
                .as("Title is actually Null").isNotNull()
                .as("Title does not contain expected text").containsIgnoringCase("Google Search")
                .matches("\\w.*"+"Google Search")
                .hasSizeBetween(15,100);



        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3"));

        assertThat(elements)
                        .hasSizeGreaterThanOrEqualTo(10)
                        .extracting(WebElement :: getText)
                        . contains("Testing Mini Bytes");

       // Assert.assertTrue(elements.size() > 10, "Number of links displayed is less than 10");

      /*  boolean isElementPresent = false;
        for(WebElement element : elements){
           if(element.getText().equalsIgnoreCase("Testing mini bytes")){
               isElementPresent = true;
               break;
           }
        }
        Assert.assertTrue(isElementPresent,"Testing mini bytes - Youtube is not present in the search results");
      */

    }


}
