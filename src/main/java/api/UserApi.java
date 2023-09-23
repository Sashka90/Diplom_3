package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApi extends BaseApiSettings{

    public static final String USER = "/auth/user";
    public static final String USER_LOGIN = "/auth/login";

    public Response delete(String accessToken) {
        return given()
                .header("authorization", accessToken)
                .spec(getBaseUrlAndContentType())
                .when()
                .delete(USER);
    }

    public Response login(User user) {
        return given()
                .spec(getBaseUrlAndContentType())
                .body(user)
                .post(USER_LOGIN);
    }

}
