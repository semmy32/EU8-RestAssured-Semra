package com.cydeo.utilities;

import static io.restassured.RestAssured.baseURI;
import org.junit.jupiter.api.BeforeAll;

public class SpartanAuthTestBase {

    @BeforeAll
    public static void init(){
        baseURI= "http://44.202.144.172:7000/";


    }




}
