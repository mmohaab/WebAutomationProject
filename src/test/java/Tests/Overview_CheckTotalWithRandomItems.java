package Tests;

import Pages.InventoryPage;
import Pages.OverviewPage;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Overview_CheckTotalWithRandomItems extends BaseTest {

    @Test
    public void checkTotalPriceWithRandomItems() throws IOException {
        String firstName = Utility.readFromProperty("environment", "FirstName");
        String lastName = Utility.readFromProperty("environment", "LastName");
        String zip = Utility.readFromProperty("environment", "ZIP");
        String randomItems = Utility.readFromProperty("environment", "NumberOfRandomItems");

        InventoryPage inventoryPage = Utility.goToInventory(driver);
        OverviewPage overviewPage = inventoryPage.addRandomItemsToCart(Integer.parseInt(randomItems))
                .goToCartPage()
                .clickOnCheckout()
                .fillCheckOut(firstName, lastName, zip);

        Assert.assertTrue(overviewPage.compareItemsPricesWithItemsTotal());
        Assert.assertTrue(overviewPage.verifyTotalAfterTax());
    }
}
