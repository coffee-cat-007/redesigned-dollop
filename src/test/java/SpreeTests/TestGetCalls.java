package SpreeTests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

public class TestGetCalls {
	
	public static final String BASE_URL= "https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/";
	
	@BeforeClass
	public void setDefaults(){
		RestAssured.baseURI = BASE_URL;

	}
	
	/*
	 * Setting headers
	 * path params
	 * get call
	 */
	@Test
	public void testGetCallWithPathParameters(){
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		
		given().headers(headers)
	      .when().get("/products/{id}",4)
	      .then().statusCode(200);
	}
	
	/*
	 * Setting content-type and accept 
	 * path params
	 * get call
	 */
	@Test
	public void testGetCallWithQueryParameters(){
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
			.queryParam("page", 1)
			.queryParam("filter[name]", "Bags")
	      .when().get("/products")
	      .then().statusCode(200);
	}
	
	
	/*
	 * verify the node value in the response
	 */
	@Test
	public void testVerifyBody(){

		given().contentType(ContentType.JSON).accept(ContentType.JSON)
	      .when().get("/products/1")
		.then().body("data.attributes.currency", equalTo("USD"));
	}
	
	
	
	
	
	
	
	
	
}
