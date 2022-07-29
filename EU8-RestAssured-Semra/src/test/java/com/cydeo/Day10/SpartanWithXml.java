package com.cydeo.Day10;

import com.cydeo.utilities.SpartanAuthTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class SpartanWithXml extends SpartanAuthTestBase {

    @DisplayName("GET request to /api/spartans and verify xml")
    @Test
    public void getSpartanXml(){
        given().accept(ContentType.XML)
                .and()
                .auth().basic("admin", "admin")
                .when()
                .get("/api/spartans")
                .then()
                .statusCode(200)
                .contentType("application/xml;charset=UTF-8")
                .body("List.item[0].name",is("Meade"))
                .body("List.item[0].gender",is("Male"))
                .log().all();
    }

         @DisplayName("GET request to /api/spartans and verify xml")
         @Test
    public void testXMLpath(){
             Response response = given().accept(ContentType.XML)
                     .and()
                     .auth().basic("admin", "admin")
                     .when()
                     .get("/api/spartans");
             XmlPath xmlPath= response.xmlPath();
            String name= xmlPath.get("List.item[0].name");

             System.out.println("name = " + name);

             int id = xmlPath.get("List.item[2].id");
             System.out.println("id = " + id);
         }

}
