package Tests;

import Pages.P02_HomePage;
import Pages.P03_RegistrationPage;
import Pages.P04_AccountPage;
import Pages.P05_LoginPage;
import Utilities.ReadDataFromFile;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class P05_LoginPageTestWithAddingLog4jMonitor extends P01_TestBase {

        P02_HomePage p02HomePage;
        P05_LoginPage loginPage;
    private static final Logger logger = LogManager.getLogger(P05_LoginPageTestWithAddingLog4jMonitor.class);

    //Common steps in login Tests
        public void GlobalLoginMethod(){
            p02HomePage = new P02_HomePage(driver);
            p02HomePage.clickOnMyAccountButton();
        }
        @Severity(SeverityLevel.CRITICAL)
        @Description("Validate that user will be able to login with valid data")
        @Story("Login Story")
        @Test
        public void ValidLogin() throws IOException {
            logger.info("Test started");
            GlobalLoginMethod();
            loginPage= p02HomePage.clickOnLoginButton();
            loginPage.loginForm(ReadDataFromFile.ReadDataFromPropFile("Email"),ReadDataFromFile.ReadDataFromPropFile("Password"));
            loginPage.ClickOnLoginButton();
            logger.info("Test completed");

    }

}
