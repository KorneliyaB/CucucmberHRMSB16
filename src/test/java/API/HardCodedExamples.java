package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {
//baseURI = baseURL + endpoint
    //given - preparation
    //when - hitting the endpoint
    //base URI = base URL

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    // value of token should be same as postman
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2OTEwODI3MjMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY5MTEyNTkyMywidXNlcklkIjoiNTY4NSJ9.fKsIrcJjxlKVqfb8RFGjl33_B45W2hhmjxQ4wZLWDIE";
    static String employee_id;
    //in this method we are going to create an employee
    //we need headers, body to prepare the request
    @Test
    public void acreateEmployee(){
        //preparing the request
        RequestSpecification request = given().header("Content-Type","application/json").
                header("Authorization", token).body("{\n" +
                        "  \"emp_firstname\": \"Tom\",\n" +
                        "  \"emp_lastname\": \"Mittil\",\n" +
                        "  \"emp_middle_name\": \"Djhone\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2005-06-12\",\n" +
                        "  \"emp_status\": \"veryHappy\",\n" +
                        "  \"emp_job_title\": \"QA Tester\"\n" +
                        "}");
        //hitting the endpoint
        Response response = request.when().post("/createEmployee.php");
        //verifying the response
        response.then().assertThat().statusCode(201);
        //  System.out.println(response);
        //this method we use to print the response of API in console
        response.prettyPrint();
        //verify all the values and headers from response
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Tom"));
        response.then().assertThat().body("Employee.emp_middle_name", equalTo("Djhone"));
        response.then().assertThat().body("Message", equalTo("Employee Created"));
       // response.then().assertThat().header("X-Powered-By","PHP/7.2.18");
        //it will return the employee id and saved it in variable
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);
    }

    @Test
    public void bgetCreatedEmployee(){
        RequestSpecification request = given().header("Authorization",token)
                .queryParam("employee_id", employee_id);

        Response response = request.when().get("/getOneEmployee.php");
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
        String tempEmpId = response.jsonPath().getString("employee.employee_id");
        Assert.assertEquals(employee_id,tempEmpId);
    }
    @Test
    public void cUpdateEmployee(){
        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"Vicky\",\n" +
                        "  \"emp_lastname\": \"Goat\",\n" +
                        "  \"emp_middle_name\": \"Alla\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2001-05-15\",\n" +
                        "  \"emp_status\": \"happy\",\n" +
                        "  \"emp_job_title\": \"married-no job\"\n" +
                        "}");

        Response response = request.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("Message",
                equalTo("Employee record Updated"));

    }

    @Test
    public void dgetCreatedEmployee(){
        RequestSpecification request = given().header("Authorization",token)
                .queryParam("employee_id", employee_id);

        Response response = request.when().get("/getOneEmployee.php");
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
        //       String tempEmpId = response.jsonPath().getString("employee.employee_id");
        //      Assert.assertEquals(employee_id,tempEmpId);
    }


}
