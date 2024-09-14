package APITestCase;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetBooks {

    private Response response;
    private final String booksListPath = "books";
    @Test
    public void  TestAddUserApi(){
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
        response = given().
                when().
                get(booksListPath);
        List<Map<String, Object>> books = response.as(new TypeRef<List<Map<String, Object>>>() {});
        for(Map<String,Object> book : books){
           Assert.assertTrue(book.containsKey("id")); ;
           Assert.assertTrue(book.containsKey("name")); ;
           Assert.assertTrue(book.containsKey("type")); ;
           Assert.assertTrue(book.containsKey("available")); ;
        }
    }

}