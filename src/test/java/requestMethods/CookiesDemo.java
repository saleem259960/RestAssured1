package requestMethods;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import java.util.Map;

import org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {
	//@Test(priority = 1)
	int i=10;
	public void cookiesTest() {
		given().
		when().
			get("https://www.google.com/").
		then().
			cookie("AEC", "Ad49MVFUKsnFM7TZOAzJsaKg5DQ-jsX2Sz_YmifRrQVsz8nknQuArTJFOA").
		log().all();
	}
	
		@Test(priority = 2)
		public void cookiesTest2() {
			Response res = given().
			when().
				get("https://www.google.com/");
			//Get single cookie information
//			String cookie_value = res.getCookie("AEC");
//			System.out.println("Value of cookie is "+cookie_value);
			
			//Get all cookies
		Map<String, String>cookies_values = res.getCookies();
		//System.out.println(cookies_values.keySet());
		for(String k :cookies_values.keySet())
		{
			String cookie = res.getCookie(k);
			System.out.println(k+"    "+cookie);
		}
		
		
		}
}
