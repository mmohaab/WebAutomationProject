package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {
    WebElement firstName = driver.findElement(By.id("first-name"));
    WebElement lastName = driver.findElement(By.id("last-name"));
    WebElement zipCode = driver.findElement(By.id("postal-code"));
    WebElement continueButton = driver.findElement(By.id("continue"));
    WebElement cancelButton = driver.findElement(By.id("cancel"));
    WebElement errorMessage = driver.findElement(By.className("error-message-container"));

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnContinue(){
        continueButton.click();
    }

    public OverviewPage fillCheckOut(String fName, String lName, String zip){
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        zipCode.sendKeys(zip);
        continueButton.click();
        return new OverviewPage(driver);
    }

    public Boolean errorMessageIsDisplayed(){
        return errorMessage.isDisplayed();
    }

    public CartPage cancelCheckout(){
        cancelButton.click();
        return new CartPage(driver);
    }

}

