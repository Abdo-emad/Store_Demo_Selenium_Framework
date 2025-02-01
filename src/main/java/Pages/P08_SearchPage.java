package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class P08_SearchPage extends P01_PageBase{
    public P08_SearchPage(WebDriver driver) {
        super(driver);
    }
    By searchInput = By.cssSelector("input[name='search']");
    By searchIcon = By.cssSelector("button[class=\"btn btn-default btn-lg\"]");
    By ItemHeadline = By.tagName("h4");
    By keywordSearchInput= By.cssSelector("input[id='input-search']");
    By CategoryDDL = By.cssSelector("select[class='form-control']");
    By searchBtn = By.cssSelector("input[id='button-search']");
    By EmptyMsg = By.xpath("(//p[text()='Your shopping cart is empty!'])[2]");
    By SubCategoryCheckBox= By.cssSelector("input[type='checkbox']");
    By appleCinemaItem = By.tagName("h4");

    public void EnterTextInSearchInput(String value){
        SendKeys(searchInput,value);
    }
    public void ClickOnSearchIcon(){
        ClickOnButton(searchIcon);
    }
    public String GetResults() {
        String ProductName = null;
        List<WebElement> ItemsNames = driver.findElements(ItemHeadline);
        for (WebElement product:ItemsNames){
             ProductName= product.getText();
            System.out.println(ProductName);
        }

        return ProductName;
    }
    public void NavigateToAdvancedSearch(){
        ClickOnButton(searchIcon);
    }
    public void EnterSearchValueInKeywordField(String value){
        WaitingDisplayOfElement(keywordSearchInput);
        SendKeys(keywordSearchInput,value);
    }
    public void SelectFromDDL(){
        WaitingDisplayOfElement(CategoryDDL);
        WebElement list = driver.findElement(CategoryDDL);
        Select select = new Select(list);
        select.selectByVisibleText("Components");
    }
    public void ClickOnSearchBtn(){
        ClickOnButton(searchBtn);
    }
    public String GetEmptyMessage(){
        WaitingDisplayOfElement(EmptyMsg);
        return driver.findElement(EmptyMsg).getText();
    }
    public void CheckSubCategoryCheckBox(){
        ClickOnButton(SubCategoryCheckBox);
    }
    public Boolean CheckVisibilityOfAppleCinemaItem(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(appleCinemaItem));
        return IsElementDisplayed(appleCinemaItem);
    }

}
