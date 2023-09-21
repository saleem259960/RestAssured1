package requestMethods;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class Examples {
	//@Test
	public void test_getM() {
		baseURI = "http://localhost:3000/";
		given().
			param("name", "automation")
			.get("/subjects"). 
		then().
			statusCode(200)
			.log().all();
	}
	//@Test
	public void test_postM() {
		JSONObject request = new JSONObject();
		request.put("firstname", "Arsh");
		request.put("lastname", "Khan");
		request.put("subjectid", 1);
		
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
	//@Test
	public void test_patchM() {
		JSONObject request = new JSONObject();
		
		request.put("lastname", "Khatoon");
		
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			patch("/users/4").
		then().
			statusCode(200).
			log().all();
	}
	//@Test
	public void test_putM() {
		JSONObject request = new JSONObject();
		
		request.put("firstname", "Rahul");
		request.put("lastname", "Kumar");
		request.put("subjectid", 1);
		
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			put("/users/4").
		then().
			statusCode(200).
			log().all();
	}
	@Test
	public void test_deleteM() {
		baseURI = "http://localhost:3000/";
		when().
			delete("users/4").
		then().
			statusCode(200);
	}
}
