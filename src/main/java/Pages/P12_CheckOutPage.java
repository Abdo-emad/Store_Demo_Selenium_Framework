package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class P12_CheckOutPage extends P01_PageBase{
    public P12_CheckOutPage(WebDriver driver) {
        super(driver);
    }
    By NewAddressRadioButton = By.xpath("//input[@value=\"new\"]");
    By FNameId = By.id("input-payment-firstname");
    By LNameId= By.id("input-payment-lastname");
    By AddressId= By.id("input-payment-address-1");
    By CityId = By.id("input-payment-city");
    By postCodeId = By.id("input-payment-postcode");
    By CountryId = By.id("input-payment-country");
    By StateId = By.id("input-payment-zone");
    By ContinueButton = By.id("button-payment-address");
    By ShippingContinueButton= By.id("button-shipping-address");
    By AddCommentTextArea = By.cssSelector("textarea[name=\"comment\"]");
    By DeliveryMethodContinueButton = By.id("button-shipping-method");
    By TermsAndConditionsCheckBox = By.cssSelector("input[type=\"checkbox\"]");
    By PaymentContinueButton = By.id("button-payment-method");
    By ConfirmOrderItemPrice = By.cssSelector("input[id=\"button-confirm\"]");
    By ConfirmOrdersList = By.cssSelector("div[class='table-responsive']");
    By flatPrice = By.xpath("//td[normalize-space()='$5.00']");
    By ConfirmCheckoutTotalPrice = By.xpath("(//tfoot/tr)[3]");
    By confirmOrderButton = By.id("button-confirm");
    By SuccessOrderMsg= By.cssSelector("div[id='content'] h1");
    public void ClickOnNewAddressRadioButton(){
        WaitingDisplayOfElement(NewAddressRadioButton);
        ClickOnButton(NewAddressRadioButton);
    }
    public void FillAddressForm(String FName , String LName , String Address1,String City,String PostCode){
        WaitingDisplayOfElement(FNameId);
     SendKeys(FNameId,FName);
     SendKeys(LNameId,LName);
     SendKeys(AddressId,Address1);
     SendKeys(CityId,City);
     SendKeys(postCodeId,PostCode);
    }
    public void SelectCountryDDL(String CountryName){
        ClickOnButton(CountryId);
        WebElement countryDDL = driver.findElement(CountryId);
        wait.until(ExpectedConditions.visibilityOf(countryDDL));
        Select Countryselect = new Select(countryDDL);
        Countryselect.selectByVisibleText(CountryName);
    }
    public void SelectStateDDL(String StateName) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement stateDDL = driver.findElement(StateId);
        ClickOnButton(StateId);
        wait.until(ExpectedConditions.elementToBeClickable(stateDDL));
        Select citySelect = new Select(stateDDL);
        citySelect.selectByVisibleText(StateName);
    }
    public void ClickOnContinueButton(){
        WaitingDisplayOfElement(ContinueButton);
        WebElement c = driver.findElement(ContinueButton);
        ScrollIntoElement(c);
        ClickOnButton(ContinueButton);
    }
    public void ClickOnShippingContinueButton(){
        WaitingDisplayOfElement(ShippingContinueButton);
        ClickOnButton(ShippingContinueButton);
    }
    public void EnterComment(String Comment){
        WaitingDisplayOfElement(AddCommentTextArea);
        SendKeys(AddCommentTextArea,Comment);
    }
    public void ClickOnDeliveryContinueButton(){
        WaitingDisplayOfElement(DeliveryMethodContinueButton);
        ClickOnButton(DeliveryMethodContinueButton);
    }
    public void ClickOnTermsAndConditionsCheckBox(){
        WaitingDisplayOfElement(TermsAndConditionsCheckBox);
        ClickOnButton(TermsAndConditionsCheckBox);
    }
    public void ClickOnPaymentContinueButton(){
        WaitingDisplayOfElement(PaymentContinueButton);
        ClickOnButton(PaymentContinueButton);
    }
   public double GetConfirmOrderItemPrice(){
        WaitingDisplayOfElement(ConfirmOrderItemPrice);
        return Double.parseDouble(driver.findElement(ConfirmOrderItemPrice).getText().replace("$",""));
   }
   public double GetFlatPrice(){
       return Double.parseDouble(driver.findElement(flatPrice).getText().replace("$",""));
   }
    public double GetConfirmCheckoutTotalPrice(){
        return Double.parseDouble(driver.findElement(ConfirmCheckoutTotalPrice).getText().replace("$","").replace("Total:",""));
    }

    public void ClickOnConfirmOrderButton(){
        WaitingDisplayOfElement(confirmOrderButton);
        ClickOnButton(confirmOrderButton);
    }
    public Boolean GetConfirmOrderSuccessMsg(){
        WaitingDisplayOfElement(SuccessOrderMsg);
      return   IsElementDisplayed(SuccessOrderMsg);
    }
    public double GetItemPriceFromConfirmOrderSection(String Item){
        List<WebElement> e = driver.findElements(ConfirmOrdersList);
        for (int c=0;c<e.size();c++){
            if (driver.findElements(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td")).get(c).getText().equalsIgnoreCase(Item)){
                return Double.parseDouble(driver.findElements(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[@class=\"text-right\" and contains(text(),'$')]")).get(c).getText().replace("$",""));
            }
        }
        return 0.0;
    }
}
