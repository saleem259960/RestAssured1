package requestMethods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test02_GET {
	@Test
	public void test_01() {
		given().
			header("Content-Type", "application/json").
			param("paramname", "value")
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.statusCode(200).
			body("data.id[1]", equalTo(8)).
			body("data.first_name", hasItems("Michael", "Lindsay"))
			.log().all();
	}
	
}
