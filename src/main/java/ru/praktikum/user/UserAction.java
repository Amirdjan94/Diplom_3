package ru.praktikum.user;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import ru.praktikum.data.User;
import ru.praktikum.data.UserCreds;

import static io.restassured.RestAssured.given;
import static ru.praktikum.data.Const.*;

public class UserAction {
    private String accessToken;
    private UserCreds userCreds;
    public UserAction() {
        RestAssured.baseURI = BASE_URI;
    }
    public Response deleteUser (Response response) {
        userCreds = response.as(UserCreds.class);
        accessToken = userCreds.getAccessToken().replaceFirst("Bearer ", "");
        return given()
                .auth().oauth2(accessToken)
                .when()
                .delete(CHANGE_USER_PATH);
    }
    public Response login (User user) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(LOGIN_USER_PATH);
    }
    public Response createUser (User user) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(CREATE_USER_PATH );
    }
}
