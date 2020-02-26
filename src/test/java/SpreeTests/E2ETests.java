package SpreeTests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class E2ETests {
	public static final String BASE_URL= "https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/";

	@BeforeClass
	public void setDefaults(){
		RestAssured.baseURI = BASE_URL;

	}

	/*
	 * Get Products
	 * Product details
	 * Add cart
	 * Add Item 1
	 * Add Item 2
	 * View cart
	 * Remove Line Item 1
	 * Change Quantity

	 */
	@Test
	public void testDeleteCallWithPathParameters(){

	}
}
