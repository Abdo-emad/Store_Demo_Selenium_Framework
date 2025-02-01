package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class P02_HomePage extends P01_PageBase {
   By myAccountButton = By.xpath("//span[text()='My Account']");
   By registerButton = By.linkText("Register");
    By loginButton = By.linkText("Login");
    public P02_HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnMyAccountButton(){
        WaitingDisplayOfElement(myAccountButton);
        ClickOnButton( myAccountButton);
    }

    public P03_RegistrationPage clickOnRegisterButton(){
        WaitingDisplayOfElement(registerButton);
         ClickOnButton(registerButton);
         return new P03_RegistrationPage(driver);
    }
public P05_LoginPage clickOnLoginButton(){
        WaitingDisplayOfElement(loginButton);
        ClickOnButton(loginButton);
        return new P05_LoginPage(driver);
}
}
