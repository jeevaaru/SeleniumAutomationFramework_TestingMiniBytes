package org.jeeva.tests;


import org.jeeva.pages.OrangeHRMLoginPage;
import org.jeeva.reports.ExtentReport;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public final class OrangeHRMTests extends BaseTest{

    private OrangeHRMTests(){

    }

    @Test(dataProvider="LoginTestDataProvider")
    public void loginLogoutTest(String username, String password) {
        new OrangeHRMLoginPage()
                .enterUsername(username).enterPassword(password).clickLogin()
                .clickUserName().clickLogout()
                .verifyLogout();
    }

    /*@Test(dataProvider="LoginTestDataProvider")
    public void newTest(String username, String password) {
        new OrangeHRMLoginPage()
                .enterUsername(username).enterPassword(password).clickLogin()
                .clickUserName().clickLogout()
                .verifyLogout();
    }

     */

    @DataProvider(name = "LoginTestDataProvider", parallel =true)
        public Object[][] getData()
    {
        return new Object[][]{
                {"Admin", "admin123"},
                {"Admin", "admin123"}
        };
    }

}
