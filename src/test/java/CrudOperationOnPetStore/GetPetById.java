package CrudOperationOnPetStore;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.internal.mapping.JsonbMapper;

import static io.restassured.RestAssured.*;

import javax.swing.text.AbstractDocument.Content;
public class GetPetById {

	@Test
public void findById() {
	String id="760";
	baseURI="https://petstore.swagger.io/v2";
	when().get("/pet/"+id)
	.then()
	.assertThat()
	.statusCode(200)
	.contentType(ContentType.JSON)
	.log().all();
}
}
