package Tests;

import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_InvalidLoginWithBlankFieldsTest extends BaseTest{
    @Test(description = "login with blank fields")
    public void InValidBlankLogin(){
        LoginPage loginPage = new LoginPage(driver);
        String username ="";
        String password ="";
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        loginPage.dismissError();
    }

}
