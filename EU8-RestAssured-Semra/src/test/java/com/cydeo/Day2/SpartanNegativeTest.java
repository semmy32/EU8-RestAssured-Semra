package com.cydeo.Day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;


public class SpartanNegativeTest {
    @BeforeAll
    public static void init(){
        RestAssured.baseURI="http://18.204.207.237:8000";
    }

    @DisplayName("GET request to /api/spartans/10")
   @Test
    public void test1(){
       Response response = given().accept(ContentType.XML).when().get("/api/spartans/10");
       assertEquals(406,response.statusCode());
       assertEquals("application/xml;charset=UTF-8",response.contentType());

   }

}
