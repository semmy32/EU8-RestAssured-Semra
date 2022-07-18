package com.cydeo.day4;
import com.cydeo.utilities.HRTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class
ORDSApiTestWithPath {

    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://44.202.144.172:1000/ords/hr";
    }

    @DisplayName("GET request to countries with Path method")
    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON)
                .queryParam("q", "{\"region_id\":2}")
                .when()
                .get("/countries");

        assertEquals(200, response.statusCode());

        System.out.println("response.path(\"limit\") = " + response.path("limit"));
        System.out.println("response.path(\"hasMore\") = " + response.path("hasMore"));

        String firstCountryId = response.path("items[0].country_id");
        System.out.println(firstCountryId);

        String secondCountryName = response.path("items[1].country_name");
        System.out.println("secondCountryName = " + secondCountryName);

        String countryHref = response.path("items[2].links[0].href");
        System.out.println("countryHref = " + countryHref);

    }

    @DisplayName("GET request to employees with Path method")
    @Test
    public void test2() {
        Response response = given().accept(ContentType.JSON)
                .queryParam("q", "{\"job_id\": \"IT_PROG\"}")
                .when()
                .get("/employees");

        assertEquals(200, response.statusCode());
       assertEquals("application/json", response.header("Content-Type"));

       List<String> allJobsId=response.path("items.job_id");

        for (String jobId : allJobsId) {
            assertEquals("IT_PROG",jobId);
        }

        List<String> IT_ProgNames= response.path("items.first_name");
        System.out.println(IT_ProgNames);



    }


}
