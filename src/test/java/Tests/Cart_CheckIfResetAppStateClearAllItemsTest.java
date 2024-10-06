package Tests;

import Pages.CartPage;
import Pages.InventoryPage;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Cart_CheckIfResetAppStateClearAllItemsTest extends BaseTest{
    protected CartPage cartPage;
    protected String randomItems;
    @Test(description = "Verify deleting all items in cart after resetting app state")
    public void checkIfResetAppStateClearAllItems() throws IOException {
        randomItems = Utility.readFromProperty("environment", "NumberOfRandomItems");

        InventoryPage inventoryPage = Utility.goToInventory(driver);
        inventoryPage.addRandomItemsToCart(Integer.parseInt(randomItems));
        cartPage = inventoryPage.goToCartPage();
        cartPage.clickOnResetAppState();
        Assert.assertEquals(cartPage.getNumberOfItemsOnPage(),"0");
    }
}
