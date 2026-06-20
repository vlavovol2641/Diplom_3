import io.qameta.allure.junit4.DisplayName;
import models.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.AccountPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import util.UserHelper;

public class LoginTest extends BaseTest {
    private User user;

    @Before
    public void createUser() {
        user = UserHelper.createUniqueUser();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginFromMainPageTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());

        AccountPage accountPage = new AccountPage(driver);
        accountPage.open();
        Assert.assertTrue(accountPage.isProfileDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginFromAccountLinkTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickAccountLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());

        AccountPage accountPage = new AccountPage(driver);
        accountPage.open();
        Assert.assertTrue(accountPage.isProfileDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegisterFormTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        registerPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());

        AccountPage accountPage = new AccountPage(driver);
        accountPage.open();
        Assert.assertTrue(accountPage.isProfileDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromForgotPasswordFormTest() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.open();
        forgotPasswordPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());

        AccountPage accountPage = new AccountPage(driver);
        accountPage.open();
        Assert.assertTrue(accountPage.isProfileDisplayed());
    }

    @After
    public void deleteUser() {
        UserHelper.deleteUser(user);
    }
}
