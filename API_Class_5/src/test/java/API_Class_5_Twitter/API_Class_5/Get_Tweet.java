// Get Tweet - https://api.twitter.com/1.1/statuses/home_timeline.json?count=1


package API_Class_5_Twitter.API_Class_5;

import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class Get_Tweet {
	
	public static void main(String[] args) {
		
		String consumer_key = "j8yk887WwoWoq8Tj6xCkxxpLa";
		String consumer_secret = "BL7bsVCa4i8TLGipuMRsy9ElmUMFyldGsAuUIX4fKdQzQhYeYs";
		
		String access_token = "1062358020099690498-ZniPABwnouaBnbsVgCCveI2TOCKRGo";
		String token_secret = "7uJ22ayg6vUIuu3ZwMd45brZ7PkGKNdaIsDmRXsRwWW7R";
		
		RestAssured.baseURI = "https://api.twitter.com/1.1/statuses";
		
		Response res =
				
				given()
				.contentType(ContentType.JSON)
				.auth()
				.oauth(consumer_key, consumer_secret, access_token, token_secret)
				.queryParam("count", "1")
				.when()
				.get("/home_timeline.json").then().extract().response();
		
			System.out.println(res.jsonPath().get("[0].text"));
		
	}
	

}
