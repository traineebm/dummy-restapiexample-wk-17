package com.restapiexample.allemployeesdetails;

import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class EmployeeGetTest extends TestBase {
    @Test
    public void getAllEmployeesList() {
        Response response = given()
                .when()
                .get("/v1/employees");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleUserInfo() {
        Response response = given()
                .pathParam("id",4)
                .when()
                .get("/v1/employee/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
