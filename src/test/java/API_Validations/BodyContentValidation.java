package API_Validations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class BodyContentValidation extends BeforeAndAfter {

	// working but data is getting changed constantly in petstore
@Test
public void bodyValidation() {
	String[] a= { "id ea in","ex consectetur nostrud eu amet"};
		
	resGet.then()
	.assertThat()
	.body("id",equalTo(9223372036854773000L))
	.body("name",equalTo("newname"))
	.body("category.id", equalTo(0))
	.body("photoUrls", hasItem(a))
	.body("status", equalTo("available"))
	.statusCode(200)
	.log().all();

}
}
