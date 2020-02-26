package SpreeTests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestPostCalls {

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
	public void testPostCallWithJsonBody(){
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		headers.put("Authorization", "Bearer zmvFWkWEDYGBVR8at_ViWIu1CQGoGaEigF9VbmE_GVM");
		String createJson= "{\n" +
				"  \"variant_id\": \"17\",\n" +
				"  \"quantity\": 5\n" +
				"}";
		
		Response response= given().headers(headers)
		.body(createJson)
	      .when()
	      .post("/cart/add_item");
	      		
	     int statusCode=  response.getStatusCode();
	     Assert.assertEquals(statusCode, 200);
	}
}
