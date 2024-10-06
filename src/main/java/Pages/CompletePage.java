package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompletePage extends BasePage{
    private WebElement thankYouMessage = driver.findElement(By.cssSelector("[data-test=\"complete-header\"]"));
    private WebElement HomeButton = driver.findElement(By.id("back-to-products"));

    public CompletePage(WebDriver driver) {
        super(driver);
    }

    public Boolean isThankYouMessageDisplayed(){
        return thankYouMessage.isDisplayed();
    }

    public InventoryPage goHome(){
        HomeButton.click();
        return new InventoryPage(driver);
    }
}
