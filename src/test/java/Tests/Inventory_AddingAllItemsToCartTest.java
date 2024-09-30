package Tests;

import Pages.InventoryPage;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Inventory_AddingAllItemsToCartTest extends BaseTest{

    @Test(description = "Adding all items to cart")
    public void AddAllItemsToCart() throws IOException {
        InventoryPage inventoryPage = Utility.goToInventory(driver);
        inventoryPage.setLink(Utility.readFromProperty("environment", "InventoryPage"));
        Assert.assertEquals(driver.getCurrentUrl(), inventoryPage.getLink());
        inventoryPage.addAllProductsToCart();
        Assert.assertEquals(inventoryPage.numberOnCartBadge(), String.valueOf(inventoryPage.getAddToCartButtonForAllItems().size()));
    }
}
