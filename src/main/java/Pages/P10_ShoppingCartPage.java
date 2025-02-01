package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

public class P10_ShoppingCartPage extends P01_PageBase{
    public P10_ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    By CartItemsPrices = By.xpath("//tbody//tr/td[6]");
    //By galaxyName = By.xpath("(//a[text()='Samsung Galaxy Tab 10.1'])[1]");
    By galaxyName = By.xpath("(//a[contains(text(),'Samsung Galaxy Tab 10.1')])[2]");
    By galaxyPrice = By.xpath("(//td[@class='text-right' and contains(text(),'$199.99')])[5]");
    By HpDeliveryDate = By.xpath("//small[normalize-space()='Delivery Date: 2025-01-10']");
    By HpPrice = By.xpath("(//td[text()='$100.00'])[3]");
    By totalPrice = By.xpath("(//td[contains(text(),'$299.99')])[4]");
    By CartTotalPrice = By.xpath("(//tbody//tr[2]/td[@class=\"text-right\"])[8]");
    By IpodShuffleItemName = By.xpath("(//a[text()='iPod Shuffle'])[2]");
    By IpodShuffleItemPrice= By.xpath("(//tbody/tr/td[@class='text-right'])[8]");
    By checkOutBtn = By.xpath("//a[text()='Checkout']");
    By TableStrippedCartItemName = By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]");
    By TableStrippedCartItemPrice = By.xpath("//body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/div[1]/table[1]/tbody[1]/tr[2]/td[2]");
    By ViewCartButton = By.xpath("//a[normalize-space()='View Cart']");
    By cartTotalDiv = By.cssSelector("ul[class=\"dropdown-menu pull-right\"]");
    By CartDiv =By.cssSelector(".btn-inverse");
    By ItemInfo = By.id("cart-total");
    By CartPrice = By.xpath("//tbody//tr//td[6]");
    By zeroItems= By.cssSelector("div[id='cart'] button");
    By SmallCartProducts = By.cssSelector("table[class*=\"table-striped\"] tbody tr");
    By ShoppingCartProductList= By.cssSelector("td[class*=\"left\"] a");
    public Boolean CheckExistingGalaxyItemInShoppingCart(){
        WaitingDisplayOfElement(galaxyName);
        return IsElementDisplayed(galaxyName);
    }
    public String GetGalaxyPrice (){
        return  driver.findElement(galaxyPrice).getText();
    }
    public String GetDeliveryDate(){
        WaitingDisplayOfElement(HpDeliveryDate);
        return driver.findElement(HpDeliveryDate).getText();
    }
    public String GetHpPrice (){
        return  driver.findElement(HpPrice).getText();
    }
    public int GetTotalPrice (){
        return Integer.parseInt(driver.findElement(totalPrice).getText());
    }
    public double GetCartItemsTotalPrice(){
        double sum = 0,price;
        int size =driver.findElements(CartItemsPrices).size();
            for (int i=0 ;i<2;i++){
           price= Double.parseDouble(driver.findElements(CartItemsPrices).get(i).getText().replace("$",""));
            sum+=price;
        }
        System.out.println("Size:"+size);
        System.out.println("Sum:"+sum);
        return sum;

    }
    public double GetCartTotalPrice(){
       return Double.parseDouble(driver.findElement(CartTotalPrice).getText().replace("$",""));
    }
    public Boolean CheckExistingIpodShuffleItemInShoppingCart(){
        WaitingDisplayOfElement(IpodShuffleItemName);
        return IsElementDisplayed(IpodShuffleItemName);
    }
    public Boolean CheckExistingIpodShuffleItemPriceInShoppingCart(){
        WaitingDisplayOfElement(IpodShuffleItemPrice);
        return IsElementDisplayed(IpodShuffleItemPrice);
    }
    public P12_CheckOutPage ClickOnCheckOutButton(){
        WebElement element = driver.findElement(checkOutBtn);
        WaitingDisplayOfElement(checkOutBtn);
        ScrollIntoElement(element);
        ClickOnButton(checkOutBtn);
        return new P12_CheckOutPage(driver);
    }
    public void OpenCartDiv(){
       /* WebElement element = driver.findElement(CartDiv);
        ScrollIntoElement(element);*/
        WaitingDisplayOfElement(CartDiv);
        ClickOnButton(CartDiv);

    }
    public Boolean CheckItemName(){
        WaitingDisplayOfElement(CartDiv);
        By e = By.cssSelector("ul[class='dropdown-menu pull-right']");
        WaitingDisplayOfElement(e);
        WaitingDisplayOfElement(TableStrippedCartItemName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ItemInfo));
       return IsElementDisplayed(TableStrippedCartItemName);
    }
    public Boolean CheckItemPrice(){
        WaitingDisplayOfElement(TableStrippedCartItemPrice);
      return   IsElementDisplayed(TableStrippedCartItemPrice);
    }
 public void ClickOnViewCartButton(){
     WaitingDisplayOfElement(ViewCartButton);
     ClickOnButton(ViewCartButton);
 }
 public double GetItemCartPrice(){
      return Double.parseDouble(driver.findElement(CartPrice).getText().replace("$",""));
 }
 public Boolean GetZeroItemsFromSmallCart(){
        WaitingDisplayOfElement(zeroItems);
     System.out.println(driver.findElement(zeroItems).getText());
       return driver.findElement(zeroItems).getText().contains("0 item(s)");
 }

 public Boolean CheckExistingOfProductName(String productName){
     List<WebElement> ProductsList = driver.findElements(ShoppingCartProductList);
     for (int i=0;i<ProductsList.size();i++){
         if (!ProductsList.get(i).getText().equalsIgnoreCase(productName)){
             return false;

         }
     }
     return true;
 }

 public Boolean CheckItemPriceFromSmallCart(String name){
        List<WebElement> SmallCartItems= driver.findElements(SmallCartProducts);
        for (int j=0;j<SmallCartItems.size();j++){
            By elementsText = By.cssSelector("table[class*=\"table-striped\"] tbody tr td[class='text-left']");
            if (!driver.findElements(elementsText).get(j).getText().equalsIgnoreCase(name)){
              driver.findElements(By.xpath("//tbody/tr/td[@class='text-right' and contains(text(),'$')]")).get(j).isDisplayed();
               return false;
            }
        }return true;


 }
}

