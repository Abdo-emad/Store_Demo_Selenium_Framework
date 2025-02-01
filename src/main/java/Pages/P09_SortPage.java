package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P09_SortPage extends P01_PageBase{
    public P09_SortPage(WebDriver driver) {
        super(driver);
    }
    By Phones_PDAs_Category= By.xpath("//a[text()='Phones & PDAs']");
    By sortByDDL = By.cssSelector("select#input-sort");
    By ItemNames = By.xpath("//div[@class=\"caption\"]/h4");
    By ItemsNameList = By.tagName("h4");
    public void ClickOnPhones_PDAs_Category(){
        WaitingDisplayOfElement(Phones_PDAs_Category);
        ClickOnButton(Phones_PDAs_Category);
    }

    public void SelectSortingFromSortDDL(String value){
        WaitingDisplayOfElement(sortByDDL);
        WebElement DDLElement= driver.findElement(sortByDDL);
        Select selectDDL= new Select(DDLElement);
        selectDDL.selectByVisibleText(value);
    }
    public String GetFirstItemName(){
        WaitingDisplayOfElement(ItemNames);
       return driver.findElements(ItemNames).get(0).getText();
    }
    public List<String> ListOfItems() {
        WaitingDisplayOfElement(ItemsNameList);
        List<WebElement> productElements = driver.findElements(ItemsNameList); // Update with actual class name
        List<String> actualOrder = new ArrayList<>();
        for (WebElement product : productElements) {
           String itemsName =product.getText().trim();
            actualOrder.add(itemsName);
        }
        return actualOrder;

    }
}
