package com.cydeo.Day5;

import com.cydeo.utilities.DBUtils;
import com.cydeo.utilities.SpartanTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class SpartanAPIvsDB extends SpartanTestBase {

    @DisplayName("GET one spartan from api and database")
    @Test
    public void testDB1() {
        String query = "select spartan_id,name,gender,phone from spartans\n" +
                "where spartan_id=15";

        Map<String, Object> dbMap = DBUtils.getRowMap(query);
        System.out.println(dbMap);


        Map<String, Object> apiMap = given().accept(ContentType.JSON).pathParam("id", 15)
                .when()
                .get("/api/spartans/{id}")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract().response().as(Map.class);
        System.out.println(apiMap);



    }


}
