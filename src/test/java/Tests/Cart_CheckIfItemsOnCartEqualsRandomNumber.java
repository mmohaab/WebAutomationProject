package Tests;

import Pages.CartPage;
import Pages.InventoryPage;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Cart_CheckIfItemsOnCartEqualsRandomNumber extends BaseTest {
    @Test(description = "Verify number of items in cart after random adding")
    public void checkIfItemsOnCartEqualsRandomNumber() throws IOException {
        String randomItems = Utility.readFromProperty("environment", "NumberOfRandomItems");
        InventoryPage inventoryPage = Utility.goToInventory(driver);
        inventoryPage.addRandomItemsToCart(Integer.parseInt(randomItems));
        CartPage cartPage = inventoryPage.goToCartPage();
        Assert.assertEquals(cartPage.getNumberOfItemsOnPage(), randomItems);
    }
}
