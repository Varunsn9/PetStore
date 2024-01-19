package API_Validations;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class StatusCodeValidation {

@Test
public void statusCodeValidation() {
	given().baseUri("https://petstore.swagger.io/v2").queryParam("status", "avaliable")
	.when()
	.get("/pet/findByStatus")
	.then()
	.assertThat()
	.statusCode(200);
}

}
