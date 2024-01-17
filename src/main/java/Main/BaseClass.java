package Main;

import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;



public class BaseClass {
	
	public RequestSpecification req=null;
	public ResponseSpecification resp=null;
	
@BeforeSuite
public void beforeMethod()
{
	req=new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").setContentType(ContentType.JSON).build();
	resp=new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
}
}
