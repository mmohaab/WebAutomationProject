package Tests;

import Pages.LoginPage;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login_ValidLoginTest extends BaseTest{
    @Test(description = "login with valid account")
    public void ValidLogin() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        String username = Utility.readFromProperty("environment", "ValidUsername");
        String password = Utility.readFromProperty("environment", "Password");
        loginPage.login(username, password);
        Assert.assertEquals(driver.getCurrentUrl(),Utility.readFromProperty("environment", "InventoryPage"));
    }
}
