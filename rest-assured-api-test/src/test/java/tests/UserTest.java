package tests;

import entity.user.User;
import io.restassured.response.Response;
import method.UserLibrary;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import runner.TestsRunner;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserTest extends TestsRunner {

    private UserLibrary userLibrary;
    private User user;


    @BeforeMethod
    public void BeforeMethod() {
        user = new User();
        userLibrary = new UserLibrary();
    }

    private String validEmail = createRandomText(5) + "@outlook.com";
    private String wrongEmail = createRandomText(5) + "outlook.com";
    private String validPassword = createRandomText(9);
    private String wrongPassword = createRandomText(7);


    @Test(priority = 1, enabled = true, description = "User Sign Up Successfully")
    public void TS0001() {
        user.setEmail(validEmail);
        user.setPassword(validPassword);
        Response response = userLibrary.signUpUser(user);
        assertEquals(response.getStatusCode(), 201, "Status code is not 201.");
        //response.jsonPath().get("access_token");

    }

    @Test(priority = 2, enabled = true, description = "User Sign Up Existing Account")
    public void TS0002() {
        user.setEmail(validEmail);
        user.setPassword(validPassword);
        Response response = userLibrary.signUpUser(user);

        assertEquals(response.getStatusCode(), 409, "Status code is not 409.");
        assertEquals(response.jsonPath().getString("message"), "User already exist!");
        assertEquals(response.jsonPath().getString("error"), "Conflict");
    }

    @Test(priority = 3, enabled = true, description = "User Sign Up With Null Params")
    public void TS0003() {
        user.setEmail("");
        user.setPassword("");
        Response response = userLibrary.signUpUser(user);
        assertTrue(response.jsonPath().getString("message").contains("password should not be empty"));
        assertTrue(response.jsonPath().getString("message").contains("email must be an email"));
        assertTrue(response.jsonPath().getString("message").contains("password must be longer than or equal to 8 characters"));
        assertTrue(response.jsonPath().getString("message").contains("email should not be empty"));
        assertEquals(response.getStatusCode(), 400, "Status code is not 400.");
    }


    @Test(priority = 4, enabled = true, description = "User Sign Up With Wrong Email and Password Length Shorter Than 8")
    public void TS0004() {
        user.setEmail(wrongEmail);
        user.setPassword(wrongPassword);
        Response response = userLibrary.signUpUser(user);
        assertEquals(response.jsonPath().getString("message[0]"), "email must be an email");
        assertEquals(response.jsonPath().getString("message[1]"), "password must be longer than or equal to 8 characters");
        assertTrue(response.jsonPath().get("statusCode") instanceof Integer);
        assertEquals(response.getStatusCode(), 400, "Status code is not 400.");

    }

    @Test(priority = 5, enabled = true, description = "User Sign Up With Valid Email and Password Length Shorter Than 8")
    public void TS0005() {
        user.setEmail(validEmail);
        user.setPassword(wrongPassword);
        Response response = userLibrary.signUpUser(user);
        assertEquals(response.jsonPath().getString("message[0]"), "password must be longer than or equal to 8 characters");
        assertEquals(response.getStatusCode(), 400, "Status code is not 400.");
    }

    @Test(priority = 6, enabled = true, description = "User Sign In Successfully", dependsOnMethods = {"TS0001"})
    public void TS0006() {
        user.setEmail(validEmail);
        user.setPassword(validPassword);
        Response response = userLibrary.signInUser(user);
        assertTrue(response.jsonPath().get("access_token") instanceof String);
        Assert.assertEquals(response.getStatusCode(), 201, "Status code is not 201.");
        //log.info(response.jsonPath().getString("access_token"));

    }

    @Test(priority = 7, enabled = true, description = "User Sign In Null Params")
    public void TS0007() {
        user.setEmail(wrongEmail);
        user.setPassword(wrongPassword);
        Response response = userLibrary.signInUser(user);
        assertTrue(response.jsonPath().getString("message").contains("Unauthorized"));
        Assert.assertEquals(response.getStatusCode(), 401, "Status code is not 401.");
    }


}
