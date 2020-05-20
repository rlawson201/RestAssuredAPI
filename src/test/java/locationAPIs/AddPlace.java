package locationAPIs;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payloads.Payload;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AddPlace {

	private String placeId;
	
	@Test (priority=1)
	public void addPlace() {
		
		//Add place info
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.addPlacePayload())
				.when().post("maps/api/place/add/json")
				.then().log().all()
				.assertThat()
				.statusCode(200)
				.header("Server", "Apache/2.4.18 (Ubuntu)").header("Access-Control-Allow-Methods", "POST").header("Content-Type", "application/json;charset=UTF-8")
				.body("scope", equalTo("APP"))
				.extract().response().asString();

		JsonPath js = new JsonPath(response);
		String responsePlaceId = js.get("place_id");
		placeId = responsePlaceId;
		
		//Get olace info and verify the response
		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
		.when().get("maps/api/place/get/json")
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.header("Server", "Apache/2.4.18 (Ubuntu)").header("Access-Control-Allow-Methods", "POST").header("Content-Type", "application/json;charset=UTF-8")
		.body("location.latitude", equalTo("-38.383494"))
		.body("location.longitude", equalTo("33.427362"))
		.body("accuracy", equalTo("50"))
		.body("name", equalTo("Frontline house"))
		.body("phone_number", equalTo("(+91) 983 893 3937"))
		.body("address", equalTo("29, side layout, cohen 09"))
		.body("types", equalTo("shoe park,shop"))
		.body("website", equalTo("http://google.com"))
		.body("language", equalTo("French-IN"));
			
	}	

/*	@Test (priority=2)
	public void UpdatePlace() {
		
		//Update place info
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.updatePlacePayload(placeId))
				.when().put("maps/api/place/update/json")
				.then().log().all()
				.assertThat().statusCode(200)
				.header("Server", "Apache/2.4.18 (Ubuntu)").header("Access-Control-Allow-Methods", "POST").header("Content-Type", "application/json;charset=UTF-8")
				.body("msg", equalTo("Address successfully updated"));
		
		//Get olace info after update and verify the response
				given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
				.when().get("maps/api/place/get/json")
				.then().log().all()
				.assertThat()
				.statusCode(200)
				.header("Server", "Apache/2.4.18 (Ubuntu)").header("Access-Control-Allow-Methods", "POST").header("Content-Type", "application/json;charset=UTF-8")
				.body("location.latitude", equalTo("-38.383494"))
				.body("location.longitude", equalTo("33.427362"))
				.body("accuracy", equalTo("50"))
				.body("name", equalTo("Frontline house"))
				.body("phone_number", equalTo("(+91) 983 893 3937"))
				.body("address", equalTo("70 Summer walk, USA"))
				.body("types", equalTo("shoe park,shop"))
				.body("website", equalTo("http://google.com"))
				.body("language", equalTo("French-IN"));
				
	}	
	
	@Test (priority=3)
	public void deletePlace() {
		
		//Delete place info
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(Payload.updatePlacePayload(placeId))
		.when().delete("maps/api/place/delete/json")
		.then().log().all()
		.assertThat().statusCode(200)
		.header("Server", "Apache/2.4.18 (Ubuntu)").header("Access-Control-Allow-Methods", "POST").header("Content-Type", "application/json;charset=UTF-8")
		.body("status", equalTo("OK"));
		
		//Get olace info after deleting place and verify the response
		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
		.when().get("maps/api/place/get/json")
		.then().log().all()
		.assertThat()
		.statusCode(404)
		.header("Server", "Apache/2.4.18 (Ubuntu)").header("Access-Control-Allow-Methods", "POST").header("Content-Type", "application/json;charset=UTF-8")
		.body("msg", equalTo("Get operation failed, looks like place_id  doesn't exists"));
		
	} */

}
