package APITestCase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class submitOrder extends Utils {
    String orderId;
        @Test
    public String submitOrder() {
            RestAssured.baseURI = "https://simple-books-api.glitch.me";
        JSONObject requestBody = new JSONObject();
        requestBody.put("bookId", "1");
        requestBody.put("customerName", "John");

        Response response = given()
                .auth()
                .oauth2(token)
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post("/orders");
        System.out.println("Order ID: " + orderId);

        response.then().assertThat().statusCode(201);
        System.out.println("Order placed successfully!");
        return  response.jsonPath().getString("orderId");
    }

    @Test
    public void updateOrder() {
        orderId = submitOrder();
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
        JSONObject requestBody = new JSONObject();
        requestBody.put("customerName", "Hady");
        Response response = given()
                .auth()
                .oauth2(token)
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .patch("/orders/" + orderId);

        System.out.println("Response Body: " + response.getBody().asString());
        System.out.println("Status Code: " + response.getStatusCode());
    }


    @Test
    public void DeleteOrder() {
        orderId = submitOrder();
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
        Response response = given()
                .auth()
                .oauth2(token)
                .when()
                .delete("/orders/" + orderId);

        System.out.println("Response Body: " + response.getBody().asString());
        System.out.println("Status Code: " + response.getStatusCode());
    }
}
