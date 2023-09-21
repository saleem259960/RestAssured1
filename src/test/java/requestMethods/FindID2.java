package requestMethods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import java.util.HashMap;

import org.hamcrest.Matchers.*;


public class FindID2 {
	 int id;
	@Test
	private void name() {
		HashMap data = new HashMap();
		data.put("Ram", "Kumer");
		data.put("Raj", "Singh");
		id = given().
			contentType("application/json").
			body(data).
		when().
			post("https://reqres.in/api/users"+id).
			jsonPath().getInt("id");
		System.out.println(id);
		
	}
}
