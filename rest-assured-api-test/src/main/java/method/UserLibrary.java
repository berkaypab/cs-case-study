package method;

import entity.user.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static data.BaseData.*;
import static io.restassured.RestAssured.given;

public class UserLibrary {
    public Response signUpUser(User user) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("email", user.getEmail());
        requestParams.put("password", user.getPassword());
        Response response = given().contentType(ContentType.JSON).body(requestParams).when().post(USER_BASE_URL + SIGN_UP_PATH);

        return response;
    }

    public Response signInUser(User user1) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("email", user1.getEmail());
        requestParams.put("password", user1.getPassword());
        Response response = given().contentType(ContentType.JSON).body(requestParams).when().post(USER_BASE_URL + SIGN_IN_PATH);
        return response;
    }
}