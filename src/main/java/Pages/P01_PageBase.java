package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P01_PageBase {
    WebDriver driver;
    WebDriverWait wait;
    public P01_PageBase(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public void ClickOnButton(By button){
        driver.findElement(button).click();
    }
    public void SendKeys(By element, String value){
        driver.findElement(element).sendKeys(value);
    }
    public void WaitingDisplayOfElement(By element){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }
    public Boolean IsElementDisplayed(By element){
        return driver.findElement(element).isDisplayed();
    }
    public String getElementText(By Tx_element){
        return driver.findElement(Tx_element).getText();
    }
    public Boolean ISBreadCrumbValueDisplayed(By Tab_value){
        return IsElementDisplayed(Tab_value);
    }
    public void ScrollIntoElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
