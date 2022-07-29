package com.cydeo.Day5;
import com.cydeo.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class HamcrestMatchersApiTest {
    // @BeforeAll
  public static void init() {
        //save baseurl inside this variable so that we don't need to type each http method.
        baseURI = "http://44.202.144.172:8000";
    }

    @DisplayName("OneSpartan with Hamcrest and chaining")
    @Test
    public void test1() {
        given().accept(ContentType.JSON)
                .and().pathParam("id", 15)
                .when()
                .get("http://44.202.144.172:8000/api/spartans/{id}")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .and()
                .body("id", equalTo(15),
                        "name", is("Meta"),
                        "gender", is("Female"),
                        "phone", is(1938695106));

    }

    @DisplayName("CBTraining Teacher request with chaining and matchers")
    @Test
    public void teacherData() {
        given().accept(ContentType.JSON)
                .and().pathParam("id",21924)
                .when()
                .get("http://api.cybertektraining.com/teacher/{id}")
                .then()
                .statusCode(200)
                .contentType("application/json;charset=UTF-8")
                .and()
                .header("Content-Length",is("283")) //headers Values are always String type!!
                .and()
                .header("Date",notNullValue())
                .and().assertThat()
                .body("teachers[0].firstName",is("Andrii"))
                .body("teachers[0].lastName",is("Shevchenko"))
                .body("teachers[0].gender",equalTo("Male"));

    }
    @DisplayName("GET request to teacher/all and chaining")
    @Test
    public void teachersTest(){

        //verify Alexander,Darleen,Sean inside the all teachers
        given()
                .accept(ContentType.JSON)
                .when()
                .get("http://api.cybertektraining.com/teacher/all")
                .then()
                .statusCode(200)
                .and()
                .body("teachers.firstName",hasItems("Leonel","Andrii","Jamal"));


    }


}