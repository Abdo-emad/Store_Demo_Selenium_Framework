package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P03_RegistrationPage extends P01_PageBase {
    public P03_RegistrationPage(WebDriver driver) {
        super(driver);
    }

    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPass = By.id("input-confirm");
    By agree = By.cssSelector("[name='agree']");
    By submit = By.cssSelector("[type='submit']");
    By requiredEMail = By.xpath("//div[text()='E-Mail Address does not appear to be valid!']");
    By requiredTelephone = By.xpath("//div[text()='Telephone must be between 3 and 32 characters!']");
    By requiredPass = By.xpath("//div[text()='Password must be between 4 and 20 characters!']");
    public void FillingRegistrationForm(String fName,String lName , String Email, String Telephone,String pass){
       WaitingDisplayOfElement(firstName);
        SendKeys(firstName, fName);
        SendKeys(lastName,lName);
        SendKeys(email,Email);
        SendKeys(telephone,Telephone);
        SendKeys(password,pass);
        SendKeys(confirmPass,pass);
        ClickOnButton(agree);
    }
    public P04_AccountPage ClickOnSubmitButton(){
        ClickOnButton(submit);
        return new P04_AccountPage(driver);
    }
    public Boolean IsEmailRequiredWarningMessageDisplayed(){
        WaitingDisplayOfElement(requiredEMail);
        return IsElementDisplayed(requiredEMail);
    }
    public Boolean IsTelephoneRequiredWarningMessageDisplayed(){
        WaitingDisplayOfElement(requiredTelephone);
        return IsElementDisplayed(requiredTelephone);
    }
    public Boolean IsPasswordRequiredWarningMessageDisplayed(){
        WaitingDisplayOfElement(requiredPass);
        return IsElementDisplayed(requiredPass);
    }
    public String GetPasswordRequiredWarningMessage(){
        WaitingDisplayOfElement(requiredPass);
        return   getElementText(requiredPass);
    }




}
