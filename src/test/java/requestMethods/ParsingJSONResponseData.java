package requestMethods;
import static io.restassured.RestAssured.*;
import java.util.Timer;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ParsingJSONResponseData {
	//@Test
	public void parcing_Test1() {
		//approach1
		/*given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/db")
		.then()
		.header("Content-Type", "application/json; charset=utf-8")
		.body("posts[0].title", equalTo("json-server"));*/
		
		
		//approach2
		Response res = given()
		 	.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/db");
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		String title = res.jsonPath().get("posts[0].title").toString();
		Assert.assertEquals(title, "json-server");
		
		
	}
	@Test
	public void SearchAnyDataFromJsonFile() {
		 Response res = given()
				 .contentType(ContentType.JSON)
		.when()
			.get("https://reqres.in/api/users?page=2");
		
		JSONObject jo = new JSONObject(res.asString());
		
		/*for(int i=0;i<jo.getJSONArray("data").length(); i++) 
		{
			String firstnames = jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			System.out.println(firstnames);
		}*/
		boolean status = false;
		for(int i=0;i<jo.getJSONArray("data").length(); i++) 
		{
			String firstnames = jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			if(firstnames.equals("Byrona"))
			{
				status = true;
				break;
			}
			
		}
		Assert.assertEquals(status, true);
	}

	
}
