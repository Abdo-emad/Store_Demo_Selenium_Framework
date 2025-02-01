package Tests;

import Pages.*;
import Utilities.ReadDataFromFile;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class P08_SearchTest extends P01_TestBase{
    P02_HomePage p02HomePage;
    P05_LoginPage loginPage;
    P04_AccountPage p04AccountPage;
    SoftAssert softAssert = new SoftAssert();
    P08_SearchPage p08SearchPage;

    @Test
    public void SearchByName() throws IOException {
        p02HomePage = new P02_HomePage(driver);
        p02HomePage.clickOnMyAccountButton();
        loginPage= p02HomePage.clickOnLoginButton();
        loginPage.loginForm(ReadDataFromFile.ReadDataFromPropFile("Email"),ReadDataFromFile.ReadDataFromPropFile("Password"));
        loginPage.ClickOnLoginButton();
       p08SearchPage = new P08_SearchPage(driver);
       p08SearchPage.EnterTextInSearchInput(ReadDataFromFile.ReadDataFromPropFile("MacItem"));
       p08SearchPage.ClickOnSearchIcon();
      softAssert.assertTrue(p08SearchPage.GetResults().contains(ReadDataFromFile.ReadDataFromPropFile("MacItem")));
       softAssert.assertAll();
        p02HomePage.clickOnMyAccountButton();
        p04AccountPage = new P04_AccountPage(driver);
        p04AccountPage.logOut();
    }

    @Test
    public void Search_in_subcategories() throws IOException {
        p02HomePage = new P02_HomePage(driver);
        p02HomePage.clickOnMyAccountButton();
        loginPage= p02HomePage.clickOnLoginButton();
        loginPage.loginForm(ReadDataFromFile.ReadDataFromPropFile("Email"),ReadDataFromFile.ReadDataFromPropFile("Password"));
        loginPage.ClickOnLoginButton();
        p08SearchPage = new P08_SearchPage(driver);
        p08SearchPage.NavigateToAdvancedSearch();
        p08SearchPage.EnterSearchValueInKeywordField(ReadDataFromFile.ReadDataFromPropFile("SearchKeyword"));
        p08SearchPage.SelectFromDDL();
        p08SearchPage.ClickOnSearchBtn();
        softAssert.assertTrue(p08SearchPage.GetEmptyMessage().contains(ReadDataFromFile.ReadDataFromPropFile("EmptyCartMessage")));
        p08SearchPage.CheckSubCategoryCheckBox();
        p08SearchPage.ClickOnSearchBtn();
        softAssert.assertTrue(p08SearchPage.CheckVisibilityOfAppleCinemaItem());
        softAssert.assertAll();
        p02HomePage.clickOnMyAccountButton();
        p04AccountPage = new P04_AccountPage(driver);
        p04AccountPage.logOut();
    }
}
