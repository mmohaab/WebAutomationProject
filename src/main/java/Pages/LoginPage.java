package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public final static String link = "https://automationexercise.com/login";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    WebElement loginName;
    @FindBy(id = "password")
    WebElement loginPassword;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(css = "[data-test=\"error\"]")
    WebElement errorMessage;
    @FindBy(className = "error-button")
    WebElement errorButton;

    @Step
    public void login(String email, String password) {
        loginName.sendKeys(email);
        loginPassword.sendKeys(password);
        loginButton.click();
    }
    @Step
    public Boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
    @Step
    public String errorMessageText() {
        return errorMessage.getText();
    }
    @Step
    public void dismissError() {
        errorButton.click();
    }

}

