package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Constants;

import java.time.Duration;

import static util.Constants.ACCOUNT_URL;
import static util.Constants.EXPLICIT_WAIT;

public class AccountPage {
    private final WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть личный кабинет")
    public AccountPage open() {
        driver.get(ACCOUNT_URL);
        return this;
    }

    @Step("Проверить, что открыт личный кабинет")
    public boolean isProfileDisplayed() {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.urlMatches(Constants.PROFILE_URL));
    }
}
