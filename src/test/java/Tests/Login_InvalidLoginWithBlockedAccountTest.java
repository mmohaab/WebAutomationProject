package Tests;

import Pages.LoginPage;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login_InvalidLoginWithBlockedAccountTest extends BaseTest{
    @Test(description = "login with blocked account")
    public void BlockedLogin() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        String username = Utility.readFromProperty("environment", "BlockedUsername");
        String password = Utility.readFromProperty("environment", "Password");
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals(loginPage.errorMessageText(), "Epic sadface: Sorry, this user has been locked out.");
        loginPage.dismissError();
    }
}
