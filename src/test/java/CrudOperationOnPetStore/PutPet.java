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
	userJsonObject.put("id", 0);
    userJsonObject.put("username", "va");
    userJsonObject.put("firstName", "he");
    userJsonObject.put("lastName", "aa");
    userJsonObject.put("email", "asd@gmail.com");
    userJsonObject.put("password", "aassddffgg");
    userJsonObject.put("phone", "9874563210");
    userJsonObject.put("userStatus", 0);
	
    given().body(userJsonObject)
	.when().put("/user")
	.then()
	.statusCode(200)
	.contentType(ContentType.JSON)
	.log()
	.all();
	
}
public JSONObject createPetJsonObject() {
    JSONObject petJsonObject = new JSONObject();
    int number=new Random().nextInt(1000);
    petJsonObject.put("id", number);

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
