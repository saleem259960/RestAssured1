package requestMethods;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matcher.*;

import org.testng.annotations.Test;

public class LoggingDemo {
	@Test(priority = 1)
	public void log_Test() {
		given().
			
		when().
			get("https://www.google.com/").
		then().
		log().headers();
	}
}
