package Tests;

import Pages.P02_HomePage;
import Pages.P04_AccountPage;
import Pages.P05_LoginPage;
import Pages.P09_SortPage;
import Utilities.ReadDataFromFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P09_SortTestNewWay extends P01_TestBase {
    P02_HomePage p02HomePage;
    P05_LoginPage loginPage;
    P04_AccountPage p04AccountPage;
    SoftAssert softAssert = new SoftAssert();
    P09_SortPage p09SortPage;
    @Test
    public void SortByGetLustOfItems() throws IOException {
        p02HomePage = new P02_HomePage(driver);
        p02HomePage.clickOnMyAccountButton();
        loginPage= p02HomePage.clickOnLoginButton();
        loginPage.loginForm(ReadDataFromFile.ReadDataFromPropFile("Email"),ReadDataFromFile.ReadDataFromPropFile("Password"));
        loginPage.ClickOnLoginButton();
        p09SortPage = new P09_SortPage(driver);
        p09SortPage.ClickOnPhones_PDAs_Category();
        p09SortPage.SelectSortingFromSortDDL("Name (A - Z)");
        List<String> ActualOrder= p09SortPage.ListOfItems();
        List<String> ExpectedOrder = new ArrayList<>(p09SortPage.ListOfItems());
        Collections.sort(ExpectedOrder);
        // Sort in ascending order
       // softAssert.assertEquals(ActualOrder,ExpectedOrder);
        System.out.println(ExpectedOrder);
        p09SortPage.SelectSortingFromSortDDL("Name (Z - A)");
        ActualOrder = p09SortPage.ListOfItems();
        ExpectedOrder.sort(Collections.reverseOrder()); // Descending sort
        System.out.println("Actual Order (Z-A): " + ActualOrder);
        System.out.println("Expected Order (Z-A): " + ExpectedOrder);
        softAssert.assertEquals(ActualOrder, ExpectedOrder, "Items are not sorted alphabetically (Z-A)!");

        softAssert.assertAll();
        p02HomePage.clickOnMyAccountButton();
        p04AccountPage = new P04_AccountPage(driver);
        p04AccountPage.logOut();
    }
}
