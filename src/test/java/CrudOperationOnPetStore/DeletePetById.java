package CrudOperationOnPetStore;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeletePetById {
@Test
public void deleteById() {
	int id=1010;
	baseURI="https://petstore.swagger.io/v2";
	when().delete("/pet/"+id)
	.then()
	.statusCode(200)
	.contentType(ContentType.JSON)
	.log().all();
}
}
