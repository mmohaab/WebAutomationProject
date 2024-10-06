package Tests;

import Pages.CompletePage;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class E2ETest extends BaseTest {
    @Test
    public void completeE2ETest() throws IOException {
        String firstName = Utility.readFromProperty("environment", "FirstName");
        String lastName = Utility.readFromProperty("environment", "LastName");
        String zip = Utility.readFromProperty("environment", "ZIP");
        String randomItems = Utility.readFromProperty("environment", "NumberOfRandomItems");
        String completePageLink = Utility.readFromProperty("environment", "CompletePage");

        CompletePage completePage = Utility.goToInventory(driver)
                .addRandomItemsToCart(Integer.parseInt(randomItems))
                .goToCartPage()
                .clickOnCheckout()
                .fillCheckOut(firstName, lastName, zip)
                .clickFinishButton();
        Assert.assertEquals(driver.getCurrentUrl(), completePageLink);
        Assert.assertTrue(completePage.isThankYouMessageDisplayed());
    }
}
