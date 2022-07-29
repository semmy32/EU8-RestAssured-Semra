package com.cydeo.Day10;

import com.cydeo.utilities.SpartanAuthTestBase;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JsonSchemaValidationTest extends SpartanAuthTestBase {

   @DisplayName("GET request to verify one spartan against to schema")
    @Test
    public void schemaValidation(){
       given().accept(ContentType.JSON)
               .and().pathParam("id",11)
               .and().auth().basic("admin","admin")
               .get("api/spartans/{id}")
               .then().statusCode(200)
               .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("SingleSpartanSchema.json"))
               .log().all();

   }
   @Test
public void allspartansSchemaTest(){

       given().accept(ContentType.JSON)
               .and().auth().basic("admin","admin")
               .when().get("api/spartans")
               .then().statusCode(200)
               .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/com/cydeo/Day10/allSpartansSchema.json")));


}

@DisplayName("POST an api/spartans ")
    @Test
    public void postSchemaValidation(){

       String requestPath="{\n" +
               "  \"gender\": \"Male\",\n" +
               "  \"name\": \"Witcher\",\n" +
               "  \"phone\": 999999999999\n" +
               "}";
       given().accept(ContentType.JSON).contentType(ContentType.JSON)
               .auth().basic("admin","admin")
               .body(requestPath)
               .when()
               .post("api/spartans").then().statusCode(201)
               .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/com/cydeo/Day10/spartanPostJsonSchema.json")));


}


}
