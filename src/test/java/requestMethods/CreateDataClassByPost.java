package requestMethods;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateDataClassByPost extends DataForTestsDataDrivenClass {
	//@Test(dataProvider = "CreateData")
	public void name(String firstname, String lastname, int subjectId) {
		JSONObject request = new JSONObject();
		request.put("firstname", firstname);
		request.put("lastname", lastname);
		request.put("subjectis", subjectId);
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
	}
	@Parameters({"userId"})
	@Test
	public void deleteData(int userId) {
		System.out.println("Value for userID is" +userId);
		baseURI = "http://localhost:3000/";
		when(). 
			delete("/users/"+userId). 
		then(). 
			statusCode(200);
		
	}
}
