import io.qameta.allure.junit4.DisplayName;
import models.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pages.RegisterPage;
import util.Constants;
import util.UserHelper;


public class RegisterTest extends BaseTest {
    private User user;

    @Test
    @DisplayName("Успешная регистрация пользователя")
    public void successfulRegistrationTest() {
        user = new User();
        user.setName(RandomStringUtils.randomAlphabetic(10));
        user.setEmail(RandomStringUtils.randomAlphabetic(8).toLowerCase() + "@yandex.ru");
        user.setPassword(RandomStringUtils.randomAlphanumeric(10));

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        registerPage.register(user.getName(), user.getEmail(), user.getPassword());

        Assert.assertEquals(Constants.LOGIN_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Ошибка при некорректном пароле при регистрации")
    public void incorrectPasswordRegistrationTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        registerPage.register(
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(8).toLowerCase() + "@yandex.ru",
                "12345"
        );

        Assert.assertEquals("Некорректный пароль", registerPage.getPasswordErrorText());
    }

    @After
    public void deleteRegisteredUser() {
        if (user != null) {
            UserHelper.deleteUser(user);
        }
    }
}
