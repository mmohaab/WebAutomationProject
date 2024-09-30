package Tests;

import Driver.BrowserConfig;
import Utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;
    private String homepage;

    @BeforeMethod
    public void setup() throws IOException {
        driver = new BrowserConfig().Initialize();
        homepage = Utility.readFromProperty("environment","HomePage");
        driver.get(homepage);
    }
//    @Test
//    public void TestInitiation(){
//        System.out.println("test initiated");
//        Assert.assertEquals(driver.getCurrentUrl(),homepage);
//    }
    @AfterMethod
    public void teardown(ITestResult result){
        if (!result.isSuccess()){
            Utility.takeScreenShot(driver,result.getName());
        }
        driver.quit();
    }
}
