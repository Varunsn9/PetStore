package CrudOperationOnPetStore;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.function.BiConsumer;

public class PutPet {
@Test
public void putPet() {
	baseURI="https://petstore.swagger.io/v2";
	JSONObject userJsonObject=new JSONObject();
	userJsonObject.put("id", 121);
    userJsonObject.put("username", "va");
    userJsonObject.put("firstName", "he");
    userJsonObject.put("lastName", "aa");
    userJsonObject.put("email", "asd@gmail.com");
    userJsonObject.put("password", "aassddffgg");
    userJsonObject.put("phone", "9844563210");
    userJsonObject.put("userStatus", 12);
	
    given().body(userJsonObject).contentType(ContentType.JSON)
	.when().put("/user/va")
	.then()
	.statusCode(200)
	.contentType(ContentType.JSON)
	.log()
	.all();
	
}}
