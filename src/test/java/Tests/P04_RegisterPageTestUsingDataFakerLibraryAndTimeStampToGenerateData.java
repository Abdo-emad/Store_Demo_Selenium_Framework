package Tests;

import Pages.P04_AccountPage;
import Pages.P03_RegistrationPage;
import Utilities.ReadDataFromFile;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P04_RegisterPageTestUsingDataFakerLibraryAndTimeStampToGenerateData extends P01_TestBase {
    Faker faker = new Faker();
    String E_Mail =faker.internet().emailAddress();
    SoftAssert softAssert= new SoftAssert();
    P03_RegistrationPage p03RegistrationPage;
    P04_AccountPage p04AccountPage;


    @Test
    public void validRegistration() throws IOException {
        //First Way
        //String CurrentTime = String.valueOf(System.currentTimeMillis());
        //Second Way
        String CurrentTime = new SimpleDateFormat("yyyyMMddHHmmssSSSZ").format(new Date());
        String EmailWithTimeStamp = "test"+CurrentTime+"@test.com";
        System.out.println(EmailWithTimeStamp);
     p02HomePage.clickOnMyAccountButton();
        p03RegistrationPage = p02HomePage.clickOnRegisterButton();
        p03RegistrationPage.FillingRegistrationForm("A","B",EmailWithTimeStamp,"123456789","P@ssw0rd");
        //p03RegistrationPage.FillingRegistrationForm("A","B",E_Mail,"123456789","P@ssw0rd");
     System.out.println(E_Mail);
        p04AccountPage = p03RegistrationPage.ClickOnSubmitButton();
     softAssert.assertTrue(p04AccountPage.getSuccessMessage().equalsIgnoreCase(ReadDataFromFile.ReadDataFromPropFile("RegistrationSuccessMessage")));
     softAssert.assertTrue(p04AccountPage.IsLogoutVisible());
     softAssert.assertAll();
     p04AccountPage.logOut();
    }

    @Test
    public void InvalidRegistration() throws IOException {
        p02HomePage.clickOnMyAccountButton();
        p03RegistrationPage = p02HomePage.clickOnRegisterButton();
        p03RegistrationPage.FillingRegistrationForm("A","B","","","");
        p03RegistrationPage.ClickOnSubmitButton();
        //Error message displayed under each missed field mentioned that it's required
        softAssert.assertTrue(p03RegistrationPage.IsEmailRequiredWarningMessageDisplayed());
        softAssert.assertTrue(p03RegistrationPage.IsTelephoneRequiredWarningMessageDisplayed());
        softAssert.assertTrue(p03RegistrationPage.IsPasswordRequiredWarningMessageDisplayed());
        //Fill all the data missed except the password
        p03RegistrationPage.FillingRegistrationForm("A","B",E_Mail,"5568909009097","P@");
        p04AccountPage = p03RegistrationPage.ClickOnSubmitButton();
        //Error message displayed mentioned that "Password must be between 4 and 20 characters!"
       // softAssert.assertTrue(p02RegistrationPage.GetPasswordRequiredWarningMessage().equalsIgnoreCase("Password must be between 4 and 20 characters!"));
        softAssert.assertTrue(p03RegistrationPage.GetPasswordRequiredWarningMessage().equalsIgnoreCase(ReadDataFromFile.ReadDataFromPropFile("PasswordLength")));
        softAssert.assertAll();
    }
}
