package Tests;

import Pages.P02_HomePage;
import Pages.P05_LoginPage;
import Utilities.ReadDataFromFile;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;

public class P03_LoginPageTestByReadingDataFromPropFile extends P01_TestBase {
    P02_HomePage p02HomePage;
    P05_LoginPage loginPage;
    SoftAssert softAssert = new SoftAssert();
    //Common steps in login Tests
    public void GlobalLoginMethod(){
        p02HomePage = new P02_HomePage(driver);
        p02HomePage.clickOnMyAccountButton();
    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate that user will be able to login with valid data")
    @Story("Login Story")
    @Test
    public void ValidLogin() throws IOException {
        GlobalLoginMethod();
        loginPage= p02HomePage.clickOnLoginButton();
        loginPage.loginForm(ReadDataFromFile.ReadDataFromPropFile("Email"),ReadDataFromFile.ReadDataFromPropFile("Password"));
        loginPage.ClickOnLoginButton();

    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate that user will not be able to login with invalid data")
    @Story("Login Story")
    @Test
    public void InValidLogin(){
        GlobalLoginMethod();
        loginPage= p02HomePage.clickOnLoginButton();
        loginPage.loginForm("abc123@gmail.com","P@ssw0rd");
        loginPage.ClickOnLoginButton();
        softAssert.assertTrue(loginPage.ISAlertMessageDisplayedWithInvalidLogin());
        softAssert.assertAll();
    }
}
