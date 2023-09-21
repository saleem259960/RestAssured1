package requestMethods;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matcher.*;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Header_Tests {
	//@Test
	public void headerTest() {
		given().
		when().
			get("https://www.google.com/").
		then().
		    header("Content-Type", "text/html; charset=ISO-8859-1").
		and()
		   .header("Content-Encoding", "gzip").and()
		.header("Server", "gws");
		
	}
	@Test(priority = 2)
	public void headerTest2() {
		Response res = given().
		when().
			get("https://www.google.com/");
		
		   //get single header
//		   String header_value= res.getHeader("Content-Type");
//		   System.out.println("value of header is ====>  "+header_value);
		
		   
		   //get all headers
		  Headers all_headers = res.getHeaders();
		  for(Header h:all_headers)
		  {
			  System.out.println(h.getName()+"    "+h.getValue());
		  }
		
	}
}
