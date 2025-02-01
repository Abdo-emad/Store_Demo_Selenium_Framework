package Tests;

import Pages.P02_HomePage;
import Pages.P04_AccountPage;
import Pages.P05_LoginPage;
import Pages.P07_TabletsPage;
import Utilities.ReadDataFromFile;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class P07_TabletsTest extends P01_TestBase {
    P02_HomePage p02HomePage;
    P05_LoginPage loginPage;
    P04_AccountPage p04AccountPage;
    P07_TabletsPage p07TabletsPage;
    SoftAssert softAssert = new SoftAssert();


    @Test
    public void CheckTabletsHighlightedLink() throws IOException {
        p02HomePage = new P02_HomePage(driver);
        p02HomePage.clickOnMyAccountButton();
        loginPage= p02HomePage.clickOnLoginButton();
        loginPage.loginForm(ReadDataFromFile.ReadDataFromPropFile("Email"),ReadDataFromFile.ReadDataFromPropFile("Password"));
        loginPage.ClickOnLoginButton();
        p07TabletsPage = new P07_TabletsPage(driver);
        p07TabletsPage.ClickOnTablets();
        softAssert.assertTrue(p07TabletsPage.ISBreadCrumbTabletsDisplayed());
      softAssert.assertTrue(p07TabletsPage.CheckExistingTabletsInLeftSideMenu());
        System.out.println( p07TabletsPage.CheckHighlightedLinkOfTablets());
        String expectedColor = "rgba(68, 68, 68, 1)";
        softAssert.assertEquals(p07TabletsPage.CheckHighlightedLinkOfTablets(),expectedColor,"Text is not highlighted");
        softAssert.assertAll();
        p02HomePage.clickOnMyAccountButton();
        p04AccountPage = new P04_AccountPage(driver);
        p04AccountPage.logOut();



    }
}
