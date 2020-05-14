package libraryAPIs;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payloads.Payload;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class AddBook {
	
	public String Id;
	
	@Test (dataProvider = "BookData")
	public void addBookAPI(String isbn, String aisle) {
		
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().log().all().queryParam("Content-Type","application/json")
		.body(Payload.addBookPayload(isbn,aisle))
		.when().post("/Library/Addbook.php")
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.body("Msg", equalTo("successfully added"))
		.body("ID",not(equalTo(null)))
		.extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		String responseId = js.get("ID");
		Id = responseId;
		
	}
	
	@Test (dataProvider = "BookData")
	public void deleteABook(String isbn, String aisle) {
		
		String Id = (isbn + aisle);
		
		given().log().all().queryParam("Content-Type","application/json")
		.body(Payload.deleteBooks(Id))
		.when().post("/Library/DeleteBook.php")
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.body("msg", equalTo("book is successfully deleted"))
		.extract().response().asString();
		
	}
	
	@DataProvider (name = "BookData")
	public Object[][] dataSet() {
		
		return new Object [][] {{"bcfray","2272"},{"cdcway","2204"},{"rayjae","2931"}};
		
	}

}
