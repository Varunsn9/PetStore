package PetStoreFrameWork;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;
import java.io.File;
import java.io.IOException;
import Main.BaseClassAPI;
import petRepo.Pet;
import petRepo.Status;

public class PetPostTestRequestChaning extends BaseClassAPI {

	public int id;
	public String name;

	//posting pet using postPet Test method and validating using GetPetAfterPost TestMethod
	//validating using contains string
	
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
		//Adding new Line to commit
	}

}
