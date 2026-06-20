package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.User;

import static util.Constants.BASE_URL;
import static io.restassured.RestAssured.given;

public class UserSteps {
    private static final String REGISTER_USER_HANDLER = "/api/auth/register";
    public static final String LOGIN_USER_HANDLER = "/api/auth/login";
    private static final String USER_HANDLER = "/api/auth/user";

    @Step("Создание пользователя")
    public Response registerUser(User user) {
        return given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(REGISTER_USER_HANDLER);
    }

    @Step("Логин пользователя")
    public Response loginUser(User user) {
        return given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(LOGIN_USER_HANDLER);
    }

    @Step("Удаление пользователя")
    public void deleteUser(User user) {
        given()
                .baseUri(BASE_URL)
                .header("Authorization", user.getAccessToken())
                .when()
                .delete(USER_HANDLER);
    }
}
