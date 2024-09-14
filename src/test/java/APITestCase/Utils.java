package APITestCase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.testng.annotations.BeforeTest;

public class Utils {
    public String token;

    @BeforeTest
    public String getAuthToken() {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";

        JSONObject requestBody = new JSONObject();
        requestBody.put("clientName", "TestClient");
        requestBody.put("clientEmail", "testclient@example.com");

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post("/api-clients");

        token = response.jsonPath().getString("accessToken");
        System.out.println("Access Token: " + token);
        return token;

    }

}
