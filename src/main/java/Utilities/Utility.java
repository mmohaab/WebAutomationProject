package Utilities;

import Pages.InventoryPage;
import Pages.LoginPage;
import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.HashSet;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

public class Utility {
    @Step
    public static String readFromProperty(String filename, String value) throws IOException {
        File file = new File("src/test/resources/DataProvider/" + filename + ".properties");
        InputStream inputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();
        return properties.getProperty(value);
    }
    @Step
    public static InventoryPage goToInventory(WebDriver driver) throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        String username = Utility.readFromProperty("environment", "ValidUsername");
        String password = Utility.readFromProperty("environment", "Password");
        loginPage.login(username, password);
        return new InventoryPage(driver);
    }
    @Step
    public static Set<Integer> generateRandomNumbers(int size,int items) {
        Set<Integer> numbersSet = new HashSet<>();
        while (numbersSet.size() < items) {
            numbersSet.add(new Random().nextInt(size)+1);
        }
        return numbersSet;
    }
    @Step
    public static void resetAppState(WebDriver driver){

        WebElement menu = driver.findElement(By.id("react-burger-menu-btn"));
        By resetAppState = By.id("reset_sidebar_link");
        By closemenu = By.id("react-burger-cross-btn");
        menu.click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(resetAppState));
        driver.findElement(resetAppState).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(closemenu));
        driver.findElement(closemenu).click();
    }
    @Step
    public static void logout(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement menu = driver.findElement(By.id("react-burger-menu-btn"));
        WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
        menu.click();
        logout.click();
    }
    @Step
    public static void takeScreenShot(WebDriver driver,String testName){
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationfile = new File("outputs"+File.separator+"screenshots"+File.separator+testName+".png");
        try {
            FileUtils.copyFile(file, destinationfile);
            FileUtils.forceDelete(file);
            try (InputStream inputStream = new FileInputStream(destinationfile)) {
                Allure.addAttachment("Screenshot", inputStream);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}