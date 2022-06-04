package gitHub;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndToEndTest {
	
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "https://api.github.com/users/nicks204/repos";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get();
		
		String ResponseBody = response.getBody().asString();
		
		System.out.println(ResponseBody);
		
		int ResponseCode = response.getStatusCode();
		
		Assert.assertEquals(ResponseCode, 200);
	}
	
	
	@Test
	public void test2() throws IOException {
		
		RestAssured.baseURI = "https://api.github.com/user/repos";
		
		byte[] dataBytes = Files.readAllBytes(Paths.get("data.json"));
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.auth()
                					.oauth2("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")
                					.contentType(ContentType.JSON)
									.accept(ContentType.JSON)	
									.body(dataBytes)
									.post();
		
		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
		
		int ResponseCode = response.getStatusCode();
		Assert.assertEquals(ResponseCode, 201);
	}

}

