package Tests;

import Pages.CheckoutPage;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Checkout_ValidCheckoutData extends BaseTest {
    @Test
    public void enterValidCheckoutData() throws IOException {
        String firstName = Utility.readFromProperty("environment", "FirstName");
        String lastName = Utility.readFromProperty("environment", "LastName");
        String zip = Utility.readFromProperty("environment", "ZIP");
        String overviewPageLink = Utility.readFromProperty("environment", "OverviewPage");

        CheckoutPage checkoutPage = Utility.goToInventory(driver)
                .goToCartPage()
                .clickOnCheckout();
        checkoutPage.fillCheckOut(firstName,lastName,zip);
        Assert.assertEquals(driver.getCurrentUrl(),overviewPageLink);
    }
}
