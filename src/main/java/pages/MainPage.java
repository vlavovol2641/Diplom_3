package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static util.Constants.BASE_URL;
import static util.Constants.EXPLICIT_WAIT;

public class MainPage {
    private final WebDriver driver;

    private final By loginButton = By.xpath(".//button[contains(text(), 'Войти в аккаунт')]");
    private final By accountLink = By.xpath(".//a[contains(@href, '/account')]");
    private final By bunsTab = By.xpath(".//span[text()='Булки']");
    private final By saucesTab = By.xpath(".//span[text()='Соусы']");
    private final By fillingsTab = By.xpath(".//span[text()='Начинки']");
    private final By activeConstructButton = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]//span");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть главную страницу")
    public MainPage open() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Нажать кнопку «Войти в аккаунт»")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажать кнопку «Личный кабинет»")
    public void clickAccountLink() {
        driver.findElement(accountLink).click();
    }

    @Step("Перейти к разделу «Булки»")
    public void clickBunsTab() {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(bunsTab));
        driver.findElement(bunsTab).click();
    }

    @Step("Перейти к разделу «Соусы»")
    public void clickSaucesTab() {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(saucesTab));
        driver.findElement(saucesTab).click();
    }

    @Step("Перейти к разделу «Начинки»")
    public void clickFillingsTab() {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(fillingsTab));
        driver.findElement(fillingsTab).click();
    }

    @Step("Проверить, что активна вкладка «{tabName}»")
    public boolean isTabActive(String tabName) {
        return driver.findElement(activeConstructButton).getText().equals(tabName);
    }
}
