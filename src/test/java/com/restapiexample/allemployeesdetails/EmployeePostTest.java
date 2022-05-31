package com.restapiexample.allemployeesdetails;

import com.restapiexample.dummy.model.EmployeePojo;
import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class EmployeePostTest extends TestBase {

    @Test
    public void createSingleEmployee(){
        EmployeePojo emp = new EmployeePojo();
        emp.setName("Test");
        emp.setSalary(30000);
        emp.setAge(23);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(emp)
                .when()
                .post("/create"); //id created - 561
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
