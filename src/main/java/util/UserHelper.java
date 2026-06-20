package util;

import models.User;
import org.apache.commons.lang3.RandomStringUtils;
import steps.UserSteps;

public class UserHelper {
    private static final UserSteps userSteps = new UserSteps();

    public static User createUniqueUser() {
        User user = new User();
        user.setEmail(RandomStringUtils.randomAlphabetic(8).toLowerCase() + "@yandex.ru");
        user.setPassword(RandomStringUtils.randomAlphanumeric(10));
        user.setName(RandomStringUtils.randomAlphabetic(10));
        userSteps.registerUser(user).then().statusCode(200);
        return user;
    }

    public static void deleteUser(User user) {
        user.saveAccessToken(user);
        if (user.getAccessToken() != null) {
            userSteps.deleteUser(user);
        }
    }
}
