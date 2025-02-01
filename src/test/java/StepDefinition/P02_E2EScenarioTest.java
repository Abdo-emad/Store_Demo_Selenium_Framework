package StepDefinition;

import Base.P01_Hooks;

public class P02_E2EScenarioTest extends P01_Hooks {
  /*  P02_HomePage p02HomePage;
    P05_LoginPage loginPage;
    P011_MP3_PlayersPage p011Mp3PlayersPage;
    P10_ShoppingCartPage p10ShoppingCartPage;
    SoftAssert softAssert = new SoftAssert();
    P12_CheckOutPage p12CheckOutPage;
    P04_AccountPage p04AccountPage;
    double price;

    @Given("^user login with valid \"(.*)\" and \"(.*)\"$")
    public void user_login_into_website(String email , String password){
        p02HomePage= new P02_HomePage(driver);
        p02HomePage.clickOnMyAccountButton();
        loginPage= p02HomePage.clickOnLoginButton();
        loginPage.loginForm(email,password);
    }
    @When("user click on login button")
    public void user_click_on_login_button(){
        loginPage.ClickOnLoginButton();
    }
    @And("user Click on MP3 Players then Show all MP3 Players")
    public void user_Click_on_MP3_Players_then_Show_all_MP3_Players(){
        p011Mp3PlayersPage = new P011_MP3_PlayersPage(driver);
        p011Mp3PlayersPage.ClickOnMP3PlayersCategory();
        p011Mp3PlayersPage.ClickOnShowAllMP3Players();
    }
    @And("^user Add \"(.*)\" to the cart$")
    public void user_Add_ipod_shuffle_to_the_cart(String productName){
        p011Mp3PlayersPage.loop1(productName);
    }

    @Then("Info message Success: You have added ipod shuffle to your shopping cart!")
    public void Success_Message(){
        softAssert.assertTrue(p011Mp3PlayersPage.IsIpodShuffleSuccessMsgDisplayed());
    }
    @And("user Open shopping cart")
    public void user_Open_shopping_cart(){
        p10ShoppingCartPage= new P10_ShoppingCartPage(driver);
        p10ShoppingCartPage.OpenCartDiv();
    }
    @Then("user check on the item added & it's price")
    public void CheckItemAddedAndItIsPrice(){
        softAssert.assertTrue(p10ShoppingCartPage.CheckItemName());
        softAssert.assertTrue(p10ShoppingCartPage.CheckItemPriceFromSmallCart("ipod shuffle"));
    }
    @And("user Click on View Cart")
    public void user_Click_on_View_Cart(){
        p10ShoppingCartPage.ClickOnViewCartButton();
        price = p10ShoppingCartPage.GetItemCartPrice();
    }

    @And("user Click on Checkout button")
    public void user_Click_on_Checkout_button(){
        p12CheckOutPage = p10ShoppingCartPage.ClickOnCheckOutButton();
    }
    @And("user Fill billing details by new address")
    public void FillBillingDetailsByNewAddress(){
        p12CheckOutPage.ClickOnNewAddressRadioButton();
        p12CheckOutPage.FillAddressForm("A","B","cairo","cairo","97867");
    }
    @And("user Check on Address drop down filled by new address")
    public void CheckOnAddressDDLFilled() throws IOException, InterruptedException {
        p12CheckOutPage.SelectCountryDDL("Egypt");
        p12CheckOutPage.SelectStateDDL("Al Fayyum");

    }
    @And("user Click on continue button")
    public void clickOnContinueButton(){
        p12CheckOutPage.ClickOnContinueButton();
    }

    @And("user click on continue button")
    public void ClickOnShippingContinueButton(){
        p12CheckOutPage.ClickOnShippingContinueButton();
    }
    @And("user Add Comment")
    public void AddComment() throws IOException {
        p12CheckOutPage.EnterComment("Hi,Waiting The Shipping");

    }
    @And("user Click on Continue button")
    public void ClickOnSecondContinueButton(){
        p12CheckOutPage.ClickOnDeliveryContinueButton();
    }
    @And("user check on Terms & conditions")
    public void CheckTermsAndConditions(){
        p12CheckOutPage.ClickOnTermsAndConditionsCheckBox();
    }
    @And("user Click on Continue button")
    public void ClickOnPaymentContinueButton(){
        p12CheckOutPage.ClickOnPaymentContinueButton();
    }
    @Then("Confirm order section will appear with the same prices as in shopping cart")
    public void ConfirmOrderSamePrice() throws IOException {
        softAssert.assertEquals(price, p12CheckOutPage.GetItemPriceFromConfirmOrderSection("iPod Shuffle"));

    }
    @And("Total price includes the Flat shipping rate")
    public void TotalPriceAndFlatShoppingRate() throws IOException {
        double ItemCheckoutPrice = p12CheckOutPage.GetItemPriceFromConfirmOrderSection("iPod Shuffle");
        double FlatShippingPrice= p12CheckOutPage.GetFlatPrice();
        double CheckoutTotalPrice = p12CheckOutPage.GetConfirmCheckoutTotalPrice();
        softAssert.assertEquals(ItemCheckoutPrice+FlatShippingPrice,CheckoutTotalPrice);

    }
    @And("user Click on Confirm Order button")
    public void ClickOnConfirmOrderButton(){
        p12CheckOutPage.ClickOnConfirmOrderButton();
    }

    @Then("Your order has been placed! message displayed")
    public void ConfirmOrderSuccessMessage(){
        softAssert.assertTrue(p12CheckOutPage.GetConfirmOrderSuccessMsg());
    }

    @And("zero items found in the small Shopping cart")
    public void CheckZeroItemsFoundInShoppingCart(){
        softAssert.assertTrue(p10ShoppingCartPage.GetZeroItemsFromSmallCart());
        softAssert.assertAll();
    }

    @And("user Log out successfully")
    public void LogoutSuccessfully(){
        p02HomePage.clickOnMyAccountButton();
        p04AccountPage = new P04_AccountPage(driver);
        p04AccountPage.logOut();
    }
*/
}
