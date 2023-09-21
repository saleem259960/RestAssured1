package requestMethods;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class DataDrivenExamples {
	//@DataProvider(name="multipleData")
	public Object dataDrivenMethod() {
//		Object data[][] = new Object[2][3];
//		data[0][0] = "Rajkumar";
//		data[0][1] = "Malhotra";
//		data[0][2] = 101;
//		
//		data[1][0] = "Arun";
//		data[1][1] = "Sexsena";
//		data[1][2] = 102;
		
		//return data;
		return new Object[][] {
			{"Ram", "Singh", 201},
			{"Shyam", "Pwanr", 202},
			{"Gabbar", "Singh", 203}
		};
	}
	//@Test(dataProvider = "multipleData")
	public void post_Test(String firstname, String lastname, int subjectId) {
		JSONObject request = new JSONObject();
		request.put("firstname", firstname);
		request.put("lastname", lastname);
		request.put("subjectid", subjectId);
		
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
	
	@DataProvider(name = "DataDelete")
	public Object dataForDealete() {
		return new Object[] {
		1,3,5,7
		};
	}
	@Test(dataProvider = "DataDelete")
	public void test_delete(int userId) {
		baseURI = "http://localhost:3000/";
		when().
			delete("/users/"+userId).
		then().
			statusCode(200).
			log().all();
	}
}
