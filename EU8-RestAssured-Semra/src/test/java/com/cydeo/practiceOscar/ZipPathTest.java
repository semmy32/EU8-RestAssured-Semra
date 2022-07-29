package com.cydeo.practiceOscar;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ZipPathTest extends ZipBase{

@Test
    public void pathTest(){
    Response response= given().accept(ContentType.JSON)
            .pathParam("zip", 22031)
            .when()
            .get("/{zip}");

    response.prettyPrint();

    assertEquals((200), response.statusCode());
    assertEquals("application/json",response.getContentType());

    assertTrue(response.headers().hasHeaderWithName("Report-To"));

    assertEquals("22031", response.path("\'post code\'"));

    assertEquals("United States", response.path("country"));
    assertEquals("US", response.path("\'country abbreviation\'"));

    assertEquals("Fairfax", response.path("places[0].\'place name\'"));
    assertEquals("38.8604", response.path("places[0].latitude"));


    JsonPath jsonPath= response.jsonPath();

    assertEquals("United States", jsonPath.get("country"));


/*
    Exercise with Path Method
Given Accept application/json
And path zipcode is 22031
When I send a GET request to /us endpoint
Then status code must be 200
And content type must be application/json
And Server header is cloudflare
And Report-To header exists
And body should contains following information
   post code is 22031
   country  is United States
   country abbreviation is US
   place name is Fairfax
   state is Virginia
   latitude is 38.8604
    */



}

}
