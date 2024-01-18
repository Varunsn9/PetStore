package CrudOperationOnPetStore;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertThat;

import java.util.Random;
import java.util.function.BiConsumer;

public class PutPet {

	static String username;

	@Test
	public void putPet() {
		baseURI="https://petstore.swagger.io/v2";
		username="va";
		//Validating weather the body already existing 
		when().get("/user/"+username)
		.then().assertThat().statusCode(200).log().all();
		
		//Updating body
		JSONObject userJsonObject=userBody();
		given().body(userJsonObject).contentType(ContentType.JSON)
		.when().put("/user/"+username)
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();

		//validation weather the body is updated
		when().get("/user/"+username)
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}



	public static JSONObject userBody() {
		JSONObject userJsonObject=new JSONObject();
		userJsonObject.put("id", 121);
		userJsonObject.put("username", username);
		userJsonObject.put("firstName", "he");
		userJsonObject.put("lastName", "aa");
		userJsonObject.put("email", "asd@gmail.com");
		userJsonObject.put("password", "aassddffgg");
		userJsonObject.put("phone", "9844563210");
		userJsonObject.put("userStatus", 12);
		return userJsonObject;
	}
}
