package Driver;

import Utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;


public class BrowserConfig {

    public WebDriver Initialize() throws IOException {
        WebDriver driver;
        String browser = Utility.readFromProperty("environment","Browser");
        switch (browser.toLowerCase()) {

            case ("edge"):
                driver = new EdgeDriver();
                break;

            case ("firefox"):
                driver = new FirefoxDriver();
                break;

            default:
                driver = new ChromeDriver();
                break;
        }
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return driver;
    }
}
