package requestMethods;
import static io.restassured.RestAssured.*;

public class PathAndQueryParameters {
	public void queryAndPathParameters() {
		//https://reqres.in/api/users?page=2
		given().
			pathParam("myparam", "users").
			queryParam("page", 2).
			queryParam("id", "5").
		when().
			get("https://reqres.in/api/{myparam}").
		then().
			statusCode(200).
		log().all();
	}
}
