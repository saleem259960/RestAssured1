package requestMethods;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class FindID {
	@DataProvider(name = "post")
	public Object post_Req() {
		JSONObject request = new JSONObject();
		return new Object [][] {
			{"firstname", "ahmad"},
			{"lastname", "Ali"}
		};
	}
	@Test(dataProvider = "post")
	public void post_ReqN(String str) {
		int id;
	id=	given().
			//contentType(ContentType.JSON).
			contentType("application/json").
			//body(str).
		when().
			post("https://reqres.in/api/users").
			jsonPath().getInt(str);
		//then().
	System.out.println(id);
	}
}
