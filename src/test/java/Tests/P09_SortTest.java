package Tests;

import Pages.*;
import Utilities.ReadDataFromFile;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class P09_SortTest extends P01_TestBase {
    P02_HomePage p02HomePage;
    P05_LoginPage loginPage;
    P04_AccountPage p04AccountPage;
    SoftAssert softAssert = new SoftAssert();
    P09_SortPage p09SortPage;
    @Test
    public void Sort() throws IOException {
        p02HomePage = new P02_HomePage(driver);
        p02HomePage.clickOnMyAccountButton();
        loginPage= p02HomePage.clickOnLoginButton();
        loginPage.loginForm(ReadDataFromFile.ReadDataFromPropFile("Email"),ReadDataFromFile.ReadDataFromPropFile("Password"));
        loginPage.ClickOnLoginButton();
        p09SortPage = new P09_SortPage(driver);
        p09SortPage.ClickOnPhones_PDAs_Category();
        p09SortPage.SelectSortingFromSortDDL("Name (A - Z)");
        softAssert.assertTrue(p09SortPage.GetFirstItemName().equalsIgnoreCase("HTC Touch HD"));
        System.out.println(p09SortPage.GetFirstItemName());
        p09SortPage.SelectSortingFromSortDDL("Name (Z - A)");
        softAssert.assertTrue(p09SortPage.GetFirstItemName().equalsIgnoreCase("Palm Treo Pro"));
        System.out.println(p09SortPage.GetFirstItemName());
         softAssert.assertAll();
        p02HomePage.clickOnMyAccountButton();
        p04AccountPage = new P04_AccountPage(driver);
        p04AccountPage.logOut();
    }
}
