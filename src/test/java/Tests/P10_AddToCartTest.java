package Tests;

import Pages.P02_HomePage;
import Pages.P05_LoginPage;
import Pages.P07_TabletsPage;
import Pages.P10_ShoppingCartPage;
import Utilities.ReadDataFromFile;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.apache.poi.ss.formula.functions.T;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class P10_AddToCartTest extends P01_TestBase{
    P02_HomePage p02HomePage;
    P05_LoginPage loginPage;
    P07_TabletsPage p07TabletsPage;
    P10_ShoppingCartPage p10ShoppingCartPage;
    SoftAssert softAssert = new SoftAssert();


    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate that user will be able to Add Items To Cart")
    @Story("Add To Cart Story")
    @Test
    public void AddItemsToCart() throws IOException {
        p02HomePage = new P02_HomePage(driver);
        p02HomePage.clickOnMyAccountButton();
        loginPage= p02HomePage.clickOnLoginButton();
        loginPage.loginForm(ReadDataFromFile.ReadDataFromPropFile("Email"),ReadDataFromFile.ReadDataFromPropFile("Password"));
        loginPage.ClickOnLoginButton();
        p07TabletsPage= new P07_TabletsPage(driver);
        p07TabletsPage.ClickOnTablets();
       // p07TabletsPage.ClickOnTabletsItemsAddToCart();
        p07TabletsPage.SelectSpecificProductFromTabletCategory(ReadDataFromFile.ReadDataFromPropFile("TabletCategoryProduct"));
        softAssert.assertTrue(p07TabletsPage.AddToCartSuccessMessage().contains(ReadDataFromFile.ReadDataFromPropFile("AddToCartSuccessMsg")));
        p07TabletsPage.ClickOnShoppingCart();
        p10ShoppingCartPage = new P10_ShoppingCartPage(driver);
        p10ShoppingCartPage.CheckExistingGalaxyItemInShoppingCart();
        p07TabletsPage.ClickOnLaptop();
        p07TabletsPage.AllTabletsDCategory();
       // p07TabletsPage.HPDeviseAddToCart();
        p07TabletsPage.SelectSpecificProductFromHpCategory(ReadDataFromFile.ReadDataFromPropFile("HpProduct"));
        p07TabletsPage.EnterDeliveryDate(ReadDataFromFile.ReadDataFromPropFile("deliveryDate"));
        p07TabletsPage.AddToCartButton();
        p07TabletsPage.ClickOnShoppingCart();
        String extractedDate = p10ShoppingCartPage.GetDeliveryDate().replace("Delivery Date: ", "");
        softAssert.assertEquals(extractedDate,ReadDataFromFile.ReadDataFromPropFile("deliveryDate"));
        System.out.println(extractedDate);
        softAssert.assertEquals(p10ShoppingCartPage.GetCartItemsTotalPrice(),p10ShoppingCartPage.GetCartTotalPrice());
        System.out.println("Items Total price:"+p10ShoppingCartPage.GetCartItemsTotalPrice());
        System.out.println("Cart Total price:"+p10ShoppingCartPage.GetCartTotalPrice());
        softAssert.assertAll();
    }
}
