package Tests;

import Pages.P04_AccountPage;
import Pages.P02_HomePage;
import Pages.P05_LoginPage;
import Pages.P03_RegistrationPage;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class P05_LoginPageTest extends P01_TestBase {
    Faker faker = new Faker();
    String E_Mail =faker.internet().emailAddress();
    P02_HomePage p02HomePage;
    P03_RegistrationPage p03RegistrationPage;
    P04_AccountPage p04AccountPage;
    P05_LoginPage loginPage;
    SoftAssert softAssert = new SoftAssert();
    //Common steps in login Tests
    public void GlobalLoginMethod(){
        p02HomePage = new P02_HomePage(driver);
        p02HomePage.clickOnMyAccountButton();
    }

    @Test
    public void ValidLogin(){
        GlobalLoginMethod();
        p03RegistrationPage = p02HomePage.clickOnRegisterButton();
        p03RegistrationPage.FillingRegistrationForm("aa","bb",E_Mail,"6542688999","P@ssw0rd");
        System.out.println(E_Mail);
        p04AccountPage = p03RegistrationPage.ClickOnSubmitButton();
        p02HomePage.clickOnMyAccountButton();
        p04AccountPage.logOut();
        p02HomePage.clickOnMyAccountButton();
        loginPage= p02HomePage.clickOnLoginButton();
        loginPage.loginForm(E_Mail,"P@ssw0rd");
        loginPage.ClickOnLoginButton();

    }
    @Test
    public void InValidLogin(){
        GlobalLoginMethod();
        loginPage= p02HomePage.clickOnLoginButton();
        loginPage.loginForm(E_Mail+"00","P@ssw0rd");
        loginPage.ClickOnLoginButton();
        softAssert.assertTrue(loginPage.ISAlertMessageDisplayedWithInvalidLogin());
        softAssert.assertAll();


    }
}
