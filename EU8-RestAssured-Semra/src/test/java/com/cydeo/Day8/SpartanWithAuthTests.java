package com.cydeo.Day8;

import com.cydeo.utilities.SpartanAuthTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpartanWithAuthTests extends SpartanAuthTestBase {

    @DisplayName("GET api/spartans as a public user expect 401 ")
    @Test
    public void test1() {
        given().accept(ContentType.JSON)
                .when()
                .get("/api/spartans")
                .then().statusCode(401)
                .log().all();
    }


    @DisplayName("GET api/spartans as admin  user expect 200 ")
    @Test
    public void test2() {
        given().auth().basic("admin", "admin")
                .accept(ContentType.JSON)
                .when()
                .get("/api/spartans")
                .then().statusCode(200)
                .log().all();

    }

    @DisplayName("DELETE /spartans/{id} as editor user expect 403 ")
    @Test
    public void test3() {
        given().auth().basic("editor", "editor")
                .accept(ContentType.JSON)
                .and().pathParam("id",30)
                .when()
                .delete("/api/spartans/{id}")
                .then().statusCode(403)
                .log().all();

    }
    @DisplayName("POST api/spartans as admin user expect 201")
    @Test
    public void test4(){
        String requestAdmin="{ \"gender\": \"Female\", \"name\": \"Mine\", \"phone\": 112233445566}";
        Response response1 = given().auth().basic("admin","admin")
                .accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(requestAdmin)
                .when()
                .post("/api/spartans");

        assertThat(response1.statusCode(),is(201));
        assertThat(response1.contentType(),is("application/json"));
        assertThat(response1.path("success"),is("A Spartan is Born!"));
        assertThat(response1.path("data.name"),is("Mine"));

    }

    @DisplayName("DELETE api/spartans/{id} as an admin user expect 204")
    @Test
    public void test5(){
        given().auth().basic("admin","admin")
                .contentType(ContentType.JSON)
                .pathParam("id",102)
                .when()
                .delete("/api/spartans/{id}")
                .then().statusCode(204);

    }
    @DisplayName("DELETE api/spartans/{id} as an editor expect 403")
   @Test
    public void test6(){
        given().auth().basic("editor","editor")
                .contentType(ContentType.JSON)
                .pathParam("id",99)
                .when()
                .delete("/api/spartans/{id}")
                .then().statusCode(403)
                .body("error",equalTo("Forbidden"));


    }

    @DisplayName("POST api/spartans as a user expect 403")
    @Test
    public void test7(){
        String requestAdmin="{ \"gender\": \"Female\", \"name\": \"Mine\", \"phone\": 112233445566}";

        given().auth().basic("user","user")
                .accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(requestAdmin)
                .when()
                .post("/api/spartans")
                .then().statusCode(403);

    }
}