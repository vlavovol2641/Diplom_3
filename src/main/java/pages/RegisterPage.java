package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static util.Constants.EXPLICIT_WAIT;
import static util.Constants.LOGIN_URL;
import static util.Constants.REGISTER_URL;

public class RegisterPage {
    private final WebDriver driver;

    private final By nameInput = By.xpath(".//label[text()='Имя']/following-sibling::input");
    private final By emailInput = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By passwordInput = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    private final By registerButton = By.xpath(".//button[contains(text(), 'Зарегистрироваться')]");
    private final By loginLink = By.xpath(".//a[contains(@href, '/login')]");
    private final By passwordError = By.xpath(".//p[contains(@class, 'input__error')]");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу регистрации")
    public RegisterPage open() {
        driver.get(REGISTER_URL);
        return this;
    }

    @Step("Ввести имя")
    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    @Step("Ввести email")
    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Ввести пароль")
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Нажать кнопку «Зарегистрироваться»")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Зарегистрировать пользователя")
    public void register(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        clickRegisterButton();
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.or(
                        ExpectedConditions.urlToBe(LOGIN_URL),
                        ExpectedConditions.visibilityOfElementLocated(passwordError)
                ));
    }

    @Step("Получить текст ошибки пароля")
    public String getPasswordErrorText() {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(passwordError))
                .getText();
    }

    @Step("Перейти ко входу")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}
