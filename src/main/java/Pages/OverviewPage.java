package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OverviewPage extends BasePage {

    private List<WebElement> itemsPrices;
    private WebElement itemsTotal = driver.findElement(By.className("summary_subtotal_label"));
    private WebElement tax = driver.findElement(By.className("summary_tax_label"));
    private WebElement total = driver.findElement(By.className("summary_total_label"));
    private WebElement finishButton = driver.findElement(By.id("finish"));

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public float sumOfItemsPrices(){
        float sum = 0;
        try{
            itemsPrices = driver.findElements(By.className("inventory_item_price"));
            for(WebElement item : itemsPrices){
                String price = item.getText();
                sum +=  Float.parseFloat(price.replace("$",""));
            }
            return sum;
        }catch (Exception e){
            return 0;
        }
    }

    public float itemtotals(){
        return Float.parseFloat(itemsTotal.getText().replace("Item total: $",""));
    }

    public Boolean compareItemsPricesWithItemsTotal(){
        return sumOfItemsPrices() == itemtotals();
    }

    public Boolean verifyTotalAfterTax(){
        float t1 = Float.parseFloat(tax.getText().replace("Tax: $",""));
        float t2 = Float.parseFloat(total.getText().replace("Total: $",""));
        return (t1+itemtotals())==t2;
    }

    public CompletePage clickFinishButton() {
        finishButton.click();
        return new CompletePage(driver);
    }
}
