package com.restassured.restassured;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.post;

class RestassuredApplicationTests {

	@Test
    public void testDittoSuccess(){
        RestAssured.baseURI = "https://pokeapi.co/api/v2/pokemon";
        String nome = get("/ditto").then().assertThat().statusCode(200).extract().path("name");
        assertEquals("ditto", nome);
    }

    @Test
    public void testDittoFailure(){
        RestAssured.baseURI = "https://pokeapi.co/api/v2/pokemon";
        String fail = get("/dittos").then().assertThat().statusCode(404).extract().body().asString();
        assertEquals("Not Found", fail);
    }

}
