package Tests;

import Pages.OverviewPage;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Overview_CheckTotalInEmptyCart extends BaseTest {
    @Test
            public void checkTotalPriceInEmptyCart() throws IOException {
        String firstName = Utility.readFromProperty("environment", "FirstName");
        String lastName = Utility.readFromProperty("environment", "LastName");
        String zip = Utility.readFromProperty("environment", "ZIP");

        OverviewPage overviewPage = Utility.goToInventory(driver)
                .goToCartPage()
                .clickOnCheckout()
                .fillCheckOut(firstName, lastName, zip);
        Assert.assertTrue(overviewPage.compareItemsPricesWithItemsTotal());
        Assert.assertTrue(overviewPage.verifyTotalAfterTax());
    }
}
