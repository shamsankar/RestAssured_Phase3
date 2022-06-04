package restBDD;


import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequestBDD {
	

		@Test
		public void test1() {
			Map<String,Object> MapObj = new HashMap<String,Object>();
			
			MapObj.put("name", "Dani");
			MapObj.put("Salary", "5000");
			
			RestAssured.given()
			.baseUri("http://localhost:3000/employees")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(MapObj)
			.when()
			.put("/11") //rename update
			.then()
			.log()
			.body()
			.statusCode(200)
			.body("name", Matchers.equalTo("Dani"));
		
		}
	


}
