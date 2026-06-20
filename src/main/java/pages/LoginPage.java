package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static util.Constants.EXPLICIT_WAIT;
import static util.Constants.LOGIN_URL;

public class LoginPage {
    private final WebDriver driver;

    private final By emailInput = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By passwordInput = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    private final By loginButton = By.xpath(".//button[contains(text(), 'Войти')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу входа")
    public LoginPage open() {
        driver.get(LOGIN_URL);
        return this;
    }

    @Step("Ввести email")
    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Ввести пароль")
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Нажать кнопку «Войти»")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Авторизоваться")
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.not(ExpectedConditions.urlContains("/login")));
    }
}
