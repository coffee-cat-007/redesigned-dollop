package SampleTests;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.Iterator;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

import static io.restassured.RestAssured.given;


public class BasicTests {

	/*
	 * verify the status code 
	 */
	@Test
	public void testStatusCode(){
		given().
		get("https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/products").
		then().
		statusCode(200);
	}
	
	
	/*
	 * log the request specification 
	 */
	@Test
	public void testLogging(){
	 given().
		log().all().
		get("https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/products");
		
	}
	
	/*
	 * log the request specification 
	 */
	@Test
	public void testPrintResponse(){
	Response res= given().when().
		log().all().
		get("https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/products/1");
	
	// as string
	System.out.println(res.asString());
	
	System.out.println("***************************************************************************");
	
	//pretty print
	System.out.println(res.prettyPrint());
		
	}
	
	/*
	 * verifying the node value using Hamcrest matchers
	 */
	@Test
	public void testVerifyNodeValue(){
		given().
		when().
			get("https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/products/1").
		then().
			body("data.attributes.currency", equalTo("USD"));
	}
	
	/*
	 * verifying the node value using Hamcrest matchers
	 */
//	@Test
//	public void testHasItemsInResponse(){
//		given().
//		when().
//			get("http://services.groupkt.com/country/get/all").
//		then().
//			body("RestResponse.result.name", hasItems("India","Cuba"));
//	}
	
	
	
	/*
	 * We can also log both request and response only if our validation failed:
	 */
	
	@Test
	public void testLogOnlyIfValidationFailed() {
	   // will log the request and response
	given().
		log().ifValidationFails().
	when().
		get("https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/products/1").
	then().
			body("data.attributes.currency", equalTo("INR"));
		
		
		// will not log the request and response
		given().
			log().ifValidationFails().
		when().
				get("https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/products/1").
				then().
				body("data.attributes.currency", equalTo("USD"));
	}
	
	/*
	 * measure the response time 
	 */
	@Test
	public void testResponseTime() {
	    Response response = given().
	    when().
	    	get("https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/products/");

		System.out.println("Response Time : " + response.getTime());
	}
	
	/*
	 * Specifying the Request Method
	 */
	@Test
	public void testRequestMethods(){
	    given().
	    when().
	    	request("GET", "https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/products/").
	    then().
	    	statusCode(200);
	}
	
	/*
	 * 
	 */
//	@Test
//	public void validateAnonymousRoot(){
//	given().
//	when().
//		get("http://services.groupkt.com/country/get/all").
//	then().
//	body("", hasItems("India", "Cuba"));
//
//	// or can be use as given().when().get("/json").then().body("$", hasItems(1, 2, 3)); tooo
//
//	}
	
	
	/*
	 * Validates the output 
	 * make sure "event_0.json" file is in your classpath
	 */
//	@Test
//	public void testValidateJsonSchema() {
//	    given().
//	    when().
//	    	get("/events?id=390").
//	    then().
//	    assertThat()
//	      .body(matchesJsonSchemaInClasspath("event_0.json"));
//	}
//
	/*
	 * setting headers
	 */
	@Test
	public void testHeaders() {  
	    given().
	    	header("User-Agent", "MyAppName").
	    when().
	    	get("/some valid endpoint/")
	    .then().
	      	statusCode(200);
	    
	    // example 2 
	    given().header("My-Header", "val1", "val2")
	      .when().get("/some valid endpoint/")
	      .then().statusCode(200);
	    
	    // you can use map for multiple headers
	}
	
	
//
//	/*
//	 * extracting headers
//	 */
//	@Test
//	public void testExtractHeaders() {
//	   Response res= given().
//	    	header("User-Agent", "MyAppName").
//	    when().
//	    	get("/some valid endpoint/");
//
//	   Iterator<Header> it = res.getHeaders().iterator();
//		while (it.hasNext()) {
//			Header h = (Header) it.next();
//			String headerName= h.getName();
//			String headerValue= h.getValue();
//			System.out.println("Header : " + headerName + "\n Value : " + headerValue);
//			}
//
//	}
//
//
//	/*
//	 * setting cookies
//	 */
//	@Test
//	public void testCookies() {
//	given().
//		cookie("session_id", "1234").
//	when().
//		get("/users/eugenp")
//    .then().
//    	statusCode(200);
//	}
//
//
//
	
	
}
