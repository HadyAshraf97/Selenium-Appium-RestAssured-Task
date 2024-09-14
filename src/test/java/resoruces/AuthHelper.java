package resoruces;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class AuthHelper {

    private final static String  UserName = "customer@practicesoftwaretesting.com";
    private final static String  Password = "welcome01";


    public static String getAccessToken(){
        RestAssured.baseURI = "https://api.practicesoftwaretesting.com";

        String response =    given().log().all().header("Content-Type","application/json")
                .body("{\n" +
                        "  \"email\": \""+UserName+"\",\n" +
                        "  \"password\": \""+Password+"\"\n" +
                        "}")
                .when().post("/users/login")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

        JsonPath js = new JsonPath(response);
        String accessToken = js.getString("access_token");
        return accessToken;
    }

}
