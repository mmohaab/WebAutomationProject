package Tests;

import Pages.CheckoutPage;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Checkout_InvalidFieldsUsingSpacesOnly extends BaseTest {
    @Test
    public void fillingFieldsWithSpacesOnly() throws IOException {
        String checkoutPageLink = Utility.readFromProperty("environment", "CheckoutPage");
        CheckoutPage checkoutPage = Utility.goToInventory(driver)
                .goToCartPage()
                .clickOnCheckout();
            checkoutPage.fillCheckOut(" "," "," ");
            Assert.assertEquals(driver.getCurrentUrl(),checkoutPageLink);
    }
}
