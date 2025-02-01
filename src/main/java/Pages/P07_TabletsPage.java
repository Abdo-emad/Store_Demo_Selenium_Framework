package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class P07_TabletsPage extends P01_PageBase{
    public P07_TabletsPage(WebDriver driver) {
        super(driver);
    }
   public String CategoryName;
    By tabletCategory = By.xpath("//a[text()='Tablets']");
    By tablet_LeftSide= By.xpath("//a[@class=\"list-group-item active\"]");
    By breadCrumb_Opened_Tab = By.xpath("//ul[@class='breadcrumb']//a[text()='Tablets']");
    //By breadCrumb_Opened_Tab = By.xpath("//ul[@class='breadcrumb']//a[text()='"+CategoryName+"']");
    By Tablets_AddToCart= By.xpath("//span[text()='Add to Cart']");
    By InfoAddToCartSuccessMsg = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By ShoppingCart = By.xpath("//span[normalize-space()='Shopping Cart']");
    By LaptopCategory = By.xpath("//a[text()='Laptops & Notebooks']");
    By AllTablets = By.xpath("//a[text()='Show All Laptops & Notebooks']");
   By HPAddToCart = By.xpath("(//span[text()='Add to Cart'])[1]");
   By deliveryDateInput = By.xpath("//input[@data-date-format='YYYY-MM-DD']");
   By AddToCartBtn = By.id("button-cart");
   public void EnterDeliveryDate(String deliveryDate){
       WaitingDisplayOfElement(deliveryDateInput);
       driver.findElement(deliveryDateInput).clear();
       SendKeys(deliveryDateInput,deliveryDate);

   }
   public void AddToCartButton()
   {
       WaitingDisplayOfElement(AddToCartBtn);
       ClickOnButton(AddToCartBtn);
   }

    public void ClickOnTablets(){
        ClickOnButton(tabletCategory);
    }
    public void ClickOnLaptop(){
        ClickOnButton(LaptopCategory);
    }
    public void AllTabletsDCategory(){
        WaitingDisplayOfElement(AllTablets);
        ClickOnButton(AllTablets);
    }
    public void HPDeviseAddToCart(){
        WaitingDisplayOfElement(HPAddToCart);
        ClickOnButton(HPAddToCart);
    }
    public Boolean CheckExistingTabletsInLeftSideMenu(){
        WaitingDisplayOfElement(tablet_LeftSide);
       return IsElementDisplayed(tablet_LeftSide);
    }
    public String CheckHighlightedLinkOfTablets(){
      WebElement element =driver.findElement(tablet_LeftSide);
      return element.getCssValue("outline-color");
    }
    public Boolean ISBreadCrumbTabletsDisplayed(){
        WaitingDisplayOfElement(breadCrumb_Opened_Tab);
       return ISBreadCrumbValueDisplayed(breadCrumb_Opened_Tab);
    }
    public void ClickOnTabletsItemsAddToCart(){
        WaitingDisplayOfElement(Tablets_AddToCart);
        ClickOnButton(Tablets_AddToCart);
    }
public String AddToCartSuccessMessage(){
        WaitingDisplayOfElement(InfoAddToCartSuccessMsg);
        return driver.findElement(InfoAddToCartSuccessMsg).getText();
}
public void ClickOnShoppingCart(){
       WaitingDisplayOfElement(ShoppingCart);
       wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCart));
        ClickOnButton(ShoppingCart);
}
public  void SelectSpecificProductFromTabletCategory(String ProductName){
       By ProductsElement = By.cssSelector(".product-layout");
       List<WebElement> ProductsList= driver.findElements(ProductsElement);
       for (int i=0;i<ProductsList.size();i++){
           if (driver.findElements(By.cssSelector("div[class=\"caption\"] h4")).get(i).getText().equalsIgnoreCase(ProductName)){
               driver.findElements(By.xpath("//button[normalize-space()='Add to Cart']")).get(i).click();
               break;
           }
       }
}
public void SelectSpecificProductFromHpCategory(String HpProductName){
    By ProductsElement = By.cssSelector(".product-layout");
    List<WebElement> ProductsList= driver.findElements(ProductsElement);
    for (int j=0;j<ProductsList.size();j++){
        if (driver.findElements(By.cssSelector("div h4")).get(j).getText().equalsIgnoreCase(HpProductName)){
            driver.findElements(By.xpath("//span[text()='Add to Cart']")).get(j).click();
            break;
        }

    }
}


}
