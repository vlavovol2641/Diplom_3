package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static util.Constants.FORGOT_PASSWORD_URL;

public class ForgotPasswordPage {
    private final WebDriver driver;

    private final By loginLink = By.cssSelector(".Auth_link__1fOlj");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу восстановления пароля")
    public ForgotPasswordPage open() {
        driver.get(FORGOT_PASSWORD_URL);
        return this;
    }

    @Step("Перейти ко входу")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}
