package PetStoreFrameWork;

import org.hamcrest.Matcher;
import org.hamcrest.core.StringContains;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;
import java.io.File;
import java.io.IOException;

import Main.BaseClass;
import petRepo.Pet;
import petRepo.Status;

public class PetTest extends BaseClass {

	public int id;
	public String name;

	@Test
	public void postPet() throws Throwable, DatabindException, IOException
	{
		id=101;
		name="Fluu";
		
		Pet jobj=new Pet(101,"Fluu" ,Status.pending);
		ObjectMapper obj=new ObjectMapper();
		obj.writerWithDefaultPrettyPrinter().writeValue(new File("./pet.json"),jobj);
		given().spec(req).body(jobj)
		.when().post("/pet")
		.then().spec(resp).assertThat().statusCode(200).log().all();
	}
	
	
	@Test(dependsOnMethods = "postPet" )
	public void GetPetAfterPost() throws Throwable, DatabindException, IOException
	{
		given().spec(req)
		.when().get("/pet/"+id)
		.then().spec(resp).assertThat().body(containsString("abcd.com")).log().all();
	}

	//@Test
	public void getTest() {
		given().spec(req).queryParam("status", Status.pending)
		.when().get("/pet/findByStatus")
		.then().spec(resp).statusCode(200).log().all();
	}
}
