package CrudOperationOnPetStore;
import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;



public class PostPet {

	int id;

	@Test
	public void postPet() {
		baseURI="https://petstore.swagger.io/v2";
		JSONObject petJsonObject = createPetJsonObject();

		given()
		.contentType(ContentType.JSON)
		.body(petJsonObject)
		.when()
		.post("/pet") // Replace with your actual API endpoint
		.then()
		.statusCode(200)
		.log().all(); // Replace with the expected status code

		//validating the pet
		when().get("/pet/"+id)
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();

	}


	public JSONObject createPetJsonObject() {
		JSONObject petJsonObject = new JSONObject();
		int number=new Random().nextInt(1000);
		id=number;
		petJsonObject.put("id", id);

		JSONObject category = new JSONObject();
		category.put("id", 0+number);
		category.put("name", "string");
		petJsonObject.put("category", category);

		petJsonObject.put("name", "daoggie"+number);

		petJsonObject.put("photoUrls",new String[]{"string"});

		JSONObject tag = new JSONObject();
		tag.put("id", 0);
		tag.put("name", "aang"+number);
		petJsonObject.put("tags", new JSONObject[]{tag});

		petJsonObject.put("status", "available");

		return petJsonObject;
	}



}
