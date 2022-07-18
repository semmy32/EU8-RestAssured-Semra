package com.cydeo.Day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;


public class HrGetRequests {
    @BeforeAll
    public static void init(){
        RestAssured.baseURI="http://44.202.144.172:1000/ords/hr";
    }

    @DisplayName("GET request to regions")
    @Test
    public void test1(){
        Response response=RestAssured.given().accept(ContentType.JSON).when().get("/regions");
        System.out.println(response.statusCode());
    }
    @DisplayName("GET request to /regions/2")
    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .when()
                .get("/regions/2");

        //verify status code
        assertEquals(200,response.statusCode());
        //verify content type
        assertEquals("application/json",response.contentType());

        response.prettyPrint();

        //verify body contains Americas
        assertTrue(response.body().asString().contains("Americas"));

    }




}
