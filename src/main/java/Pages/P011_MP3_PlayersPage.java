package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P011_MP3_PlayersPage extends P01_PageBase{
    public P011_MP3_PlayersPage(WebDriver driver) {
        super(driver);
    }
    By MP3_PlayersElement = By.xpath("//li[@class='dropdown']/a[text()='MP3 Players']");
    By ShowAllMP3Players= By.xpath("//div[@class='dropdown-menu']/a[text()='Show All MP3 Players']");
    By IpodShuffleAddToCartBtn = By.xpath("(//span[text()='Add to Cart'])[3]");
    By IpodShuffleSuccessMsg = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By Mp3Products = By.cssSelector(".product-layout");

    public void loopOnProductsList(String ProductTextName){
        List<WebElement> products = driver.findElements(Mp3Products);

        for (int i=0;i<products.size();i++){
          String ProductsName=  driver.findElements(By.cssSelector("div h4")).get(i).getText();
          if (ProductsName.equalsIgnoreCase(ProductTextName)){
              driver.findElements(By.xpath("//div[@class=\"button-group\"]/button/span[text()='Add to Cart']")).get(i).click();
          break;
          }
        }
    }

    public void ClickOnMP3PlayersCategory(){
        WaitingDisplayOfElement(MP3_PlayersElement);
        ClickOnButton(MP3_PlayersElement);
    }
    public void ClickOnShowAllMP3Players(){
        WaitingDisplayOfElement(ShowAllMP3Players);
        ClickOnButton(ShowAllMP3Players);
    }
    public void ClickOnAddToCartOfIpodShuffleItem(){
        WaitingDisplayOfElement(IpodShuffleAddToCartBtn);
        ClickOnButton(IpodShuffleAddToCartBtn);
    }
    public Boolean IsIpodShuffleSuccessMsgDisplayed(){
        WaitingDisplayOfElement(IpodShuffleSuccessMsg);
        return IsElementDisplayed(IpodShuffleSuccessMsg);
    }



}
