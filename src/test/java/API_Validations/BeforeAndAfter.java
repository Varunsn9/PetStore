package API_Validations;

import org.testng.annotations.BeforeTest;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class BeforeAndAfter {
	Response resGet;
	long id=9223372036854773000l;
	
@BeforeTest
public void beforeTest() {
	resGet=given().baseUri("https://petstore.swagger.io/v2").when().get("/pet/"+id);
	}
}
