package Tests;

import Pages.P02_HomePage;
import Utilities.ReadDataFromFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.io.IOException;

public class P01_TestBase {
    public WebDriver driver;
    P02_HomePage p02HomePage;
    @BeforeMethod
    public void SetUp() throws IOException {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ReadDataFromFile.ReadDataFromPropFile("BaseURL"));
        p02HomePage = new P02_HomePage(driver);

    }

    @AfterMethod
    public void Quit(){
        driver.quit();
    }
}



