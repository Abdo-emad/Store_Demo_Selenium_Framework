package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_LoginPage extends P01_PageBase {
    public P05_LoginPage(WebDriver driver) {
        super(driver);
    }

   By emailField = By.id("input-email");
   By passwordField = By.id("input-password");
   By loginBtn = By.cssSelector("[value='Login']");
   By alertMsg = By.cssSelector(".alert");
   public void loginForm(String email , String pass){
       SendKeys(emailField,email);
       SendKeys(passwordField,pass);
   }

   public void ClickOnLoginButton(){
       ClickOnButton(loginBtn);
   }
  public Boolean ISAlertMessageDisplayedWithInvalidLogin(){
       return IsElementDisplayed(alertMsg);
  }
}
