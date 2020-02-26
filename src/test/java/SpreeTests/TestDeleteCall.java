package SpreeTests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TestDeleteCall {
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
	public void testDeleteCallWithPathParameters(){
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		headers.put("Authorization", "Bearer zmvFWkWEDYGBVR8at_ViWIu1CQGoGaEigF9VbmE_GVM");
		given().headers(headers)
	      .when().delete("/cart/remove_line_item/{line_item_id}",314)
	      .then().statusCode(200);
	}
}
