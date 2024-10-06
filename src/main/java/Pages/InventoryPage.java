package Pages;

import Utilities.Utility;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage extends BasePage{
    private String link;
    private List<WebElement> numberOfItemsOnPage = driver.findElements(By.cssSelector("[data-test=\"inventory-item\"]"));
    private List<WebElement> addToCartButtonForAllItems = driver.findElements(By.className("btn_inventory"));
    private List<WebElement> selectedItems;
    private WebElement itemButton;
    private WebElement cartIcon = driver.findElement(By.cssSelector("[data-test=\"shopping-cart-link\"]"));
    private WebElement CartIconBadgeNumber;
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Step
    public List<WebElement> getAddToCartButtonForAllItems() {
        return addToCartButtonForAllItems;
    }
    @Step
    public void addAllProductsToCart(){
        for(WebElement item : addToCartButtonForAllItems){
            item.click();
        }
    }
    @Step
    public String numberOnCartBadge(){
        try {
            CartIconBadgeNumber = driver.findElement(By.cssSelector("[data-test=\"shopping-cart-badge\"]"));
            return CartIconBadgeNumber.getText();
        }catch (Exception e){
            return "0";
        }
    }
    @Step
    public String numberOfSelectedItems(){
        try {
            selectedItems = driver.findElements(By.xpath("//button[text()='Remove']"));
            return String.valueOf(selectedItems.size());
        }catch (Exception e) {
            return "0";
        }
    }
    @Step
    public Boolean isSelectedEqualsBadge(){
        return numberOnCartBadge().equals(numberOfSelectedItems());
    }
    @Step
    public InventoryPage addRandomItemsToCart(int WantedItemsNumber){
        var items = Utility.generateRandomNumbers(numberOfItemsOnPage.size(),WantedItemsNumber);
        for(var item:items){
            itemButton = driver.findElement(By.xpath("(//button[contains(@class, 'btn_inventory')])["+item+"]"));
            itemButton.click();
        }
        return this;
    }
    @Step
    public CartPage goToCartPage(){
        cartIcon.click();
        return new CartPage(driver);
    }
    @Step
    public LoginPage logout(){
        Utility.logout(driver);
        return new LoginPage(driver);
    }
    @Step
    public InventoryPage clickOnResetAppState(){
        Utility.resetAppState(driver);
        return new InventoryPage(driver);
    }
}
