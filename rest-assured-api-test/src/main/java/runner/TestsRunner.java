package runner;

import core.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class TestsRunner extends BaseTest {

   public RequestSpecification requestSpecification;

    @BeforeMethod
    public void BeforeMethod(){
        requestSpecification  = RestAssured.given().contentType(ContentType.JSON);
    }




}
