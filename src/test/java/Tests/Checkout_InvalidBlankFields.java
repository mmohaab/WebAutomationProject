package Tests;

import Pages.CheckoutPage;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Checkout_InvalidBlankFields extends BaseTest{
    @Test
    public void invalidBlankFields() throws IOException {
        CheckoutPage checkoutPage = Utility.goToInventory(driver)
                .goToCartPage()
                .clickOnCheckout();
        checkoutPage.clickOnContinue();
        Assert.assertTrue(checkoutPage.errorMessageIsDisplayed());
    }
}
