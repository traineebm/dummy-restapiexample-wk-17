package com.restapiexample.allemployeesdetails;

import com.restapiexample.dummy.model.EmployeePojo;
import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class EmployeePutTest extends TestBase {
    @Test
    public void updateSingleEmployeeInfoWithPut(){


        EmployeePojo emp = new EmployeePojo();
        emp.setName("Mona Singh");
        emp.setSalary(50000);
        emp.setAge(33);
       // emp.setId("5");


        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id",5)
                .body(emp)
                .when()
                .put("/update/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
