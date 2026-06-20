package models;

import io.restassured.http.ContentType;

import static util.Constants.BASE_URL;
import static io.restassured.RestAssured.given;
import static steps.UserSteps.LOGIN_USER_HANDLER;

public class User {
    private String email;
    private String password;
    private String name;
    private String accessToken;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void saveAccessToken(User user) {
        this.accessToken = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(LOGIN_USER_HANDLER)
                .then()
                .extract().body().path("accessToken");
    }
}
