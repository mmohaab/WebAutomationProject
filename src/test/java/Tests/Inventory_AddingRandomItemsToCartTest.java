package Tests;

import Pages.InventoryPage;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Inventory_AddingRandomItemsToCartTest extends BaseTest{
    @Test(description = "Adding random items to cart")
    public void addRandomItems() throws IOException, InterruptedException {
        InventoryPage inventoryPage;
        String randomItems = Utility.readFromProperty("environment", "NumberOfRandomItems");
        inventoryPage = Utility.goToInventory(driver);
        inventoryPage.addRandomItemsToCart(Integer.parseInt(randomItems));
        Assert.assertEquals(inventoryPage.numberOnCartBadge(),randomItems);
    }
}
