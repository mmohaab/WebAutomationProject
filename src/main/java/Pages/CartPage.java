package Pages;

import Utilities.Utility;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @FindBy(id = "continue-shopping")
    WebElement continueShopping;
    @FindBy(id = "checkout")
    WebElement checkout;

    List<WebElement> cartItems;
    @Step
    public InventoryPage clickOnContinueShopping() {
        continueShopping.click();
        return new InventoryPage(driver);
    }
    @Step
    public CheckoutPage clickOnCheckout() {
        checkout.click();
        return new CheckoutPage(driver);
    }
    @Step
    public String getNumberOfItemsOnPage() {
        try {
            cartItems = driver.findElements(By.className("cart_item"));
            return String.valueOf(cartItems.size());
        } catch (Exception e) {
            return "0";
        }
    }
    @Step
    public CartPage clickOnResetAppState(){
        Utility.resetAppState(driver);
        return new CartPage(driver);
    }
    @Step
    public LoginPage logout(){
        Utility.logout(driver);
        return new LoginPage(driver);
    }

}