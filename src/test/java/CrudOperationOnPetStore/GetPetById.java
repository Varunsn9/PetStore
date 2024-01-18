package CrudOperationOnPetStore;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.internal.mapping.JsonbMapper;
import io.restassured.response.Response;
import petRepo.Pet;
import petRepo.PetBodyGeneric;
import petRepo.Status;

import static io.restassured.RestAssured.*;

import javax.swing.text.AbstractDocument.Content;
public class GetPetById {

	int id;	

	@Test
	public void postPetBody() {

		Pet pet=PetBodyGeneric.randomPetBody(Status.avaliable);
		baseURI="https://petstore.swagger.io/v2";
		Response res=given().body(pet).contentType(ContentType.JSON)
				.when().post("/pet");
		res.then().assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		id=res.jsonPath().get("id");
	}

	@Test
	(dependsOnMethods = "postPetBody")
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
