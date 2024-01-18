package CrudOperationOnPetStore;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Main.ListenersImplementationAPI;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petRepo.Pet;
import petRepo.PetBodyGeneric;
import petRepo.Status;

import static io.restassured.RestAssured.*;

@Listeners(ListenersImplementationAPI.class)
public class DeletePetById {
	int id;
	String name;
	@Test
public void postBody() {
		
	Pet pet=PetBodyGeneric.randomPetBody(Status.avaliable);
	baseURI="https://petstore.swagger.io/v2";
	Response res=given().body(pet).contentType(ContentType.JSON)
	.when().post("/pet");
	res.then().assertThat()
	.statusCode(200)
	.contentType(ContentType.JSON)
	.log().all();
	 id=res.jsonPath().get("id");
	name=res.jsonPath().get("name");
}
	
@Test
(dependsOnMethods ="postBody" )
public void deleteById() {
	int id=this.id;
	//deleting the pet
	baseURI="https://petstore.swagger.io/v2";
	when().delete("/pet/"+id)
	.then()
	.statusCode(200)
	.contentType(ContentType.JSON)
	.log().all();
	
	//Validating weather the pet is deleted
	when().get("/pet/"+id)
	.then().assertThat().statusCode(404)
	.log().all();
}
}
