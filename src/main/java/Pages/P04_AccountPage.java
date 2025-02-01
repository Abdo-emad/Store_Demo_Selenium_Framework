package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class P04_AccountPage extends P01_PageBase {
    public P04_AccountPage(WebDriver driver) {
        super(driver);
    }
    By successMsg = By.xpath("(//div[@id='content']//p)[1]");
    By myAccountButton = By.xpath("//span[text()='My Account']");
    //By logoutButton = By.linkText("Logout");
    By logoutButton = By.xpath("(//a[text()='Logout'])[1]");
    //Desktop locator
    By desktopDDl = By.xpath("//a[text()='Desktops']");
    By showAllDesktop = By.xpath("//a[text()='Show All Desktops']");

    public String getSuccessMessage(){
        WaitingDisplayOfElement(successMsg);
        return getElementText(successMsg);
    }
    public Boolean IsLogoutVisible(){
        WaitingDisplayOfElement(myAccountButton);
        ClickOnButton(myAccountButton);
       return IsElementDisplayed(logoutButton);
    }
    public void logOut() {
        WaitingDisplayOfElement(logoutButton);
        ClickOnButton(logoutButton);
    }
    public void SelectShowAllDesktopFromDesktopDDL(){
        WaitingDisplayOfElement(desktopDDl);
       driver.findElement(desktopDDl).click();
       WaitingDisplayOfElement(showAllDesktop);
       driver.findElement(showAllDesktop).click();
    }
}
