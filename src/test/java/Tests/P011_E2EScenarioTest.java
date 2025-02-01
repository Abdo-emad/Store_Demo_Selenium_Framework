package Tests;

import Pages.*;
import Utilities.NewWay_AccessExcelSheet2;
import Utilities.ReadDataFromFile;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class P011_E2EScenarioTest extends P01_TestBase{
    P02_HomePage p02HomePage;
    P05_LoginPage loginPage;
    P011_MP3_PlayersPage p011Mp3PlayersPage;
    P10_ShoppingCartPage p10ShoppingCartPage;
    SoftAssert softAssert = new SoftAssert();
    P12_CheckOutPage p12CheckOutPage;
    P04_AccountPage p04AccountPage;

    @DataProvider(name = "ExcelData2")
    public Object[][] ReadData() throws IOException {

        return NewWay_AccessExcelSheet2.getData("Checkout");


    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate that user will be able to Add Items To Cart Then Checkout")
    @Story("E2EScenario Story")
    @Test(dataProvider = "ExcelData2")
    public void E2EScenario(String firstName , String lastName , String Address , String City , String postCode) throws IOException, InterruptedException {
        p02HomePage = new P02_HomePage(driver);
        p02HomePage.clickOnMyAccountButton();
        loginPage= p02HomePage.clickOnLoginButton();
        loginPage.loginForm(ReadDataFromFile.ReadDataFromPropFile("Email"),ReadDataFromFile.ReadDataFromPropFile("Password"));
        loginPage.ClickOnLoginButton();
        p011Mp3PlayersPage = new P011_MP3_PlayersPage(driver);
        p011Mp3PlayersPage.ClickOnMP3PlayersCategory();
        p011Mp3PlayersPage.ClickOnShowAllMP3Players();
        p011Mp3PlayersPage.loopOnProductsList(ReadDataFromFile.ReadDataFromPropFile("ProductName"));
       // p011Mp3PlayersPage.ClickOnAddToCartOfIpodShuffleItem();
       softAssert.assertTrue(p011Mp3PlayersPage.IsIpodShuffleSuccessMsgDisplayed());
        p10ShoppingCartPage= new P10_ShoppingCartPage(driver);
        p10ShoppingCartPage.OpenCartDiv();
        softAssert.assertTrue(p10ShoppingCartPage.CheckItemName());
        softAssert.assertTrue(p10ShoppingCartPage.CheckItemPriceFromSmallCart(ReadDataFromFile.ReadDataFromPropFile("ProductName")));
        p10ShoppingCartPage.ClickOnViewCartButton();
        double price = p10ShoppingCartPage.GetItemCartPrice();
        System.out.println("Item Cart Price:"+ p10ShoppingCartPage.GetItemCartPrice());
        p12CheckOutPage = p10ShoppingCartPage.ClickOnCheckOutButton();
        p12CheckOutPage.ClickOnNewAddressRadioButton();
        p12CheckOutPage.FillAddressForm(firstName,lastName,Address,City,postCode);
        p12CheckOutPage.SelectCountryDDL(ReadDataFromFile.ReadDataFromPropFile("Country"));
        p12CheckOutPage.SelectStateDDL(ReadDataFromFile.ReadDataFromPropFile("State"));
        p12CheckOutPage.ClickOnContinueButton();
        p12CheckOutPage.ClickOnShippingContinueButton();
        p12CheckOutPage.EnterComment(ReadDataFromFile.ReadDataFromPropFile("Comment"));
        p12CheckOutPage.ClickOnDeliveryContinueButton();
        p12CheckOutPage.ClickOnTermsAndConditionsCheckBox();
        p12CheckOutPage.ClickOnPaymentContinueButton();
        System.out.println("Get IPod Product Price:"+p12CheckOutPage.GetItemPriceFromConfirmOrderSection(ReadDataFromFile.ReadDataFromPropFile("ProductName")));
        softAssert.assertEquals(price, p12CheckOutPage.GetItemPriceFromConfirmOrderSection(ReadDataFromFile.ReadDataFromPropFile("ProductName")));
        double ItemCheckoutPrice = p12CheckOutPage.GetItemPriceFromConfirmOrderSection(ReadDataFromFile.ReadDataFromPropFile("ProductName"));
        double FlatShippingPrice= p12CheckOutPage.GetFlatPrice();
        double CheckoutTotalPrice = p12CheckOutPage.GetConfirmCheckoutTotalPrice();
        softAssert.assertEquals(ItemCheckoutPrice+FlatShippingPrice,CheckoutTotalPrice);
        p12CheckOutPage.ClickOnConfirmOrderButton();
         softAssert.assertTrue(p12CheckOutPage.GetConfirmOrderSuccessMsg());
         softAssert.assertTrue(p10ShoppingCartPage.GetZeroItemsFromSmallCart());
        softAssert.assertAll();
        p02HomePage.clickOnMyAccountButton();
        p04AccountPage = new P04_AccountPage(driver);
        p04AccountPage.logOut();
    }
}
