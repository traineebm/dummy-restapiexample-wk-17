package com.restapiexample.dummy.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class VerifyTestCases {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://dummy.restapiexample.com";
        RestAssured.basePath = "/api/v1";
        response = given()
                .when()
                .get("/employees")
                .then().statusCode(200);
    }

    // 1) Verify total records are 24
    @Test
    public void test001() {

        List<String> employeeRecords = response.extract().path("data");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total no of employees' records are : " + employeeRecords.size());
        System.out.println("------------------End of Test---------------------------");
    }

    // 2) Verify data[23].id = 24
    @Test
    public void test002() {

        int data = response.extract().path("data[23].id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of data[23].id : " + data);
        System.out.println("------------------End of Test---------------------------");
    }

    // 3) Verify data[23].employee_name = “Doris Wilder”
    @Test
    public void test003() {

       String data = response.extract().path("data[23].employee_name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The data[23].employee_name is : " + data);
        System.out.println("------------------End of Test---------------------------");
    }

    // 4) Verify message = “Successfully! All records has been fetched.”
    @Test
    public void test004() {

        String expectedMessage = response.extract().path("message");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Verify all records are fetched successfully : " + expectedMessage);
        System.out.println("------------------End of Test---------------------------");
    }

    // 5) Verify status = success
    @Test
    public void test005() {

        String status = response.extract().path("status");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Verify status : " + status);
        System.out.println("------------------End of Test---------------------------");
    }

    // 6) Verify id = 3 has employee_salary = 86000
    @Test
    public void test006() {

        List<Integer> employeeSalary = response.extract().path("data.findAll{it.id==3}.employee_salary");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Verify id = 3 has salary: " + employeeSalary);

        System.out.println("------------------End of Test---------------------------");
    }

    // 7) Verify id = 6 has employee_age = 61
    @Test
    public void test007() {
        List<Integer> employeeAge = response.extract().path("data.findAll{it.id==6}.employee_age");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Verify id = 6 has age : " + employeeAge);
        System.out.println("------------------End of Test---------------------------");
    }

    // 8) Verify id = 11 has employee_name = Jena Gaines
    @Test
    public void test008() {
        List<String> employeeName = response.extract().path("data.findAll{it.id==11}.employee_name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Verify id = 11 has name: " + employeeName);
        System.out.println("------------------End of Test---------------------------");
    }

}
