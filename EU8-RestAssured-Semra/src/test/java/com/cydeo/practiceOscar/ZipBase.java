package com.cydeo.practiceOscar;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class ZipBase {

    @BeforeAll
    public static void init(){
        RestAssured.baseURI="https://api.zippopotam.us";
        RestAssured.basePath="/us";
    }

}
