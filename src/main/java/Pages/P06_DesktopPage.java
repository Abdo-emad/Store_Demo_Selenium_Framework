package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_DesktopPage extends P01_PageBase {

    public P06_DesktopPage(WebDriver driver) {
        super(driver);
    }
    By DesktopHeadLine = By.tagName("h2");
    By ItemPrices = By.xpath("//p[@class=\"price\"]");
    By CurrencyDDL = By.xpath("//span[text()='Currency']");
    By Euro= By.xpath("//button[text()='€ Euro']");

    public Boolean CheckExistingOfDesktopHeadline(){
        WaitingDisplayOfElement(DesktopHeadLine);
       return IsElementDisplayed(DesktopHeadLine);
    }
    public Boolean GetItemsPrices(String currency){
        WaitingDisplayOfElement(ItemPrices);
        int i;
       int itemsSize= driver.findElements(ItemPrices).size();
        for ( i=0;i<itemsSize;i++){
            if (driver.findElements(ItemPrices).get(i).getText().contains(currency)){
                System.out.println(driver.findElements(ItemPrices).get(i).getText());
                return true;

            }
    }
        return false;
    }

    public void OpenCurrencyDDL(){
        ClickOnButton(CurrencyDDL);
}


    public void SelectEuroValue(){
        WaitingDisplayOfElement(Euro);
        ClickOnButton(Euro);
    }

}
