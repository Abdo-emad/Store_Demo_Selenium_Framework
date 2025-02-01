package Tests;

import Pages.P02_HomePage;
import Pages.P04_AccountPage;
import Pages.P05_LoginPage;
import Pages.P06_DesktopPage;
import Utilities.ReadDataFromFile;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class P06_ChangeCurrencyTest extends P01_TestBase{

    P02_HomePage p02HomePage;
    P05_LoginPage loginPage;
    P04_AccountPage p04AccountPage;
    P06_DesktopPage p06DesktopPage;
    SoftAssert softAssert = new SoftAssert();
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate that user will be able to change website currency")
    @Story("Change Currency Story")
    @Test
    public void ChangeCurrency() throws IOException {
        p02HomePage = new P02_HomePage(driver);
        p02HomePage.clickOnMyAccountButton();
        loginPage= p02HomePage.clickOnLoginButton();
        loginPage.loginForm(ReadDataFromFile.ReadDataFromPropFile("Email"),ReadDataFromFile.ReadDataFromPropFile("Password"));
        loginPage.ClickOnLoginButton();
        p04AccountPage= new P04_AccountPage(driver);
        p04AccountPage.SelectShowAllDesktopFromDesktopDDL();
        p06DesktopPage = new P06_DesktopPage(driver);
       softAssert.assertTrue(p06DesktopPage.CheckExistingOfDesktopHeadline());
       softAssert.assertTrue(p06DesktopPage.GetItemsPrices("$"));
       p06DesktopPage.OpenCurrencyDDL();
       p06DesktopPage.SelectEuroValue();
        softAssert.assertTrue(p06DesktopPage.GetItemsPrices("€"));
       softAssert.assertAll();
       p02HomePage.clickOnMyAccountButton();
       p04AccountPage.logOut();
    }
}
