package com.cydeo.practiceOscar;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ZipTestWithHamcrest extends ZipBase{

    @Test
    public void test(){
        given().log().all().accept(ContentType.JSON)
                .and().pathParam("zip",22031)
                .when().get("/{zip}")
                .then().assertThat().statusCode(200)
                .and().contentType("application/json")
                .and().assertThat().header("Server",is("cloudflare"))
                .assertThat().header("Report-To",is(notNullValue()))
                .body("country",equalTo("United States"),
                        "'post code'",equalTo("22031"),
                        "places[0].state",is("Virginia"),
                        "places[0].'place name'",is("Fairfax"))
                .log().all();






    }

}
