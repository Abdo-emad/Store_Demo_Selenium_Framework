package Tests;

import Pages.P03_RegistrationPage;
import Pages.P04_AccountPage;
import Utilities.NewWay_AccessExcelSheet2;
import Utilities.ReadDataFromFile;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;

public class P02_RegisterPageTestReadingDataFromExcelFile_NewWayToReadDataFromExcel extends P01_TestBase {
    SoftAssert softAssert= new SoftAssert();
    P03_RegistrationPage p03RegistrationPage;
    P04_AccountPage p04AccountPage;
   // NewWay_AccessExcelSheet accessData = new NewWay_AccessExcelSheet();


 @DataProvider(name = "ExcelData2")
 public Object[][] ReadData() throws IOException {

    return NewWay_AccessExcelSheet2.getData("Register");


 }

    @Test(dataProvider = "ExcelData2")
    public void validRegistration(String fiName, String laName,String email,String telephone,String pass) throws IOException, InterruptedException {

        p02HomePage.clickOnMyAccountButton();
        p03RegistrationPage = p02HomePage.clickOnRegisterButton();
        p03RegistrationPage.FillingRegistrationForm(fiName,laName,email,telephone,pass);
        p04AccountPage = p03RegistrationPage.ClickOnSubmitButton();
        softAssert.assertTrue(p04AccountPage.getSuccessMessage().equalsIgnoreCase(ReadDataFromFile.ReadDataFromPropFile("RegistrationSuccessMessage")));
        softAssert.assertTrue(p04AccountPage.IsLogoutVisible());
        softAssert.assertAll();
        Thread.sleep(2000);
        p04AccountPage.logOut();
    }
    @Test(dataProvider = "ExcelData2")
    public void InvalidRegistration(String firstname,String lastname,String mail,String telephone) throws IOException {
        p02HomePage.clickOnMyAccountButton();
        p03RegistrationPage = p02HomePage.clickOnRegisterButton();
        p03RegistrationPage.FillingRegistrationForm(firstname,lastname,"","","");
        p03RegistrationPage.ClickOnSubmitButton();
        //Error message displayed under each missed field mentioned that it's required
        softAssert.assertTrue(p03RegistrationPage.IsEmailRequiredWarningMessageDisplayed());
        softAssert.assertTrue(p03RegistrationPage.IsTelephoneRequiredWarningMessageDisplayed());
        softAssert.assertTrue(p03RegistrationPage.IsPasswordRequiredWarningMessageDisplayed());
        //Fill all the data missed except the password
        p03RegistrationPage.FillingRegistrationForm(firstname,lastname,mail,telephone,"P@");
        p04AccountPage = p03RegistrationPage.ClickOnSubmitButton();
        //Error message displayed mentioned that "Password must be between 4 and 20 characters!"
         softAssert.assertTrue(p03RegistrationPage.GetPasswordRequiredWarningMessage().equalsIgnoreCase(ReadDataFromFile.ReadDataFromPropFile("PasswordLength")));
        softAssert.assertAll();
    }

}
