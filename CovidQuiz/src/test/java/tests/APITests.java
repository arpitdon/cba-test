package tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import screenless.APIHelpers;

import java.util.ArrayList;
import java.util.List;

public class APITests extends APIHelpers {

    public static String JWT_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJrZXkiOiJIZXJjdWxlcyIsImVtYWlsIjoiYXJwaXRyYWl6YWRhMTAyMUBnbWFpbC5jb20iLCJpYXQiOjE2MzU0MTg3MTAsImV4cCI6MTYzNTY3NzkxMH0.P6XSfk9a3OftrTQKrQaSIddxpd7lSfEFshxBNX14eRI";

    @Test
    public void test_01_generateToken_200() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject requestParams = new JSONObject();
        requestParams.put("key", "Hercules");
        requestParams.put("email", "arpitraizada1021@gmail.com");
        request.body(requestParams.toString());
        Response response = request.request(Method.POST, postAuthToken);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void test_02_verifyInvalidToken_403() {
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", JWT_TOKEN+"123");
        request.header("Accept", "application/json");
        Response response = request.request(Method.GET, getVerifyToken);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
        System.out.println("Response Status is =>  " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 403);
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertEquals(jsonPathEvaluator.get("error"), "Token Authentication failed ::: JsonWebTokenError: invalid token");
    }

    @Test
    public void test_03_verifyValidToken_200() {
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", JWT_TOKEN);
        request.header("Accept", "application/json");
        Response response = request.request(Method.GET, getVerifyToken);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
        Assert.assertEquals(response.getStatusCode(), 200);
        JSONArray JSONResponseBody = new   JSONArray(response.body().asString());
        Assert.assertEquals(JSONResponseBody.getJSONObject(0).getInt("app_id"),287);
        Assert.assertEquals(JSONResponseBody.getJSONObject(0).getString("app"),"Hercules");
    }

    @Test
    public void test_04_verifyInvalidApp_400() {
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + JWT_TOKEN);
        request.header("Content-Type", "application/json");
        request.header("Accept", "application/json");
        Response response = request.request(Method.GET, "https://supervillain.herokuapp1.com" + getVerifyToken);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
        Assert.assertEquals(response.getStatusCode(), 400);
    }

    @Test
    public void test_05_verifyGetUsers_200() {
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", JWT_TOKEN);
        request.header("Accept", "application/json");
        Response response = request.request(Method.GET, getUser);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void test_06_verifyGetUsersInvalidRequest_400() {
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", JWT_TOKEN);
        request.header("Accept", "application/json");
        Response response = request.request(Method.GET, getUser);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
        Assert.assertEquals(response.getStatusCode(), 400);
    }

    @Test
    public void test_07_verifyAddUsersRequest_201() {
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", JWT_TOKEN);
        request.header("Accept", "application/json");
        request.header("Content-Type", "application/json");
        JSONObject requestParams = new JSONObject();
        requestParams.put("username", "ArpitCBA");
        requestParams.put("score", 4000);
        request.body(requestParams.toString());
        Response response = request.request(Method.POST, postAddUser);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
        Assert.assertEquals(response.getStatusCode(), 201);
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertEquals(jsonPathEvaluator.get("status"), "success");
        Assert.assertEquals(jsonPathEvaluator.get("message"), "User added.");
    }

    @Test
    public void test_08_verifyUpdateUserRequest_204() {
        String user = "ArpitCBA";
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", JWT_TOKEN);
        request.header("Accept", "application/json");
        request.header("Content-Type", "application/json");
        JSONObject requestParams = new JSONObject();
        requestParams.put("username", user);
        requestParams.put("score", 5000);
        request.body(requestParams.toString());
        Response response = request.request(Method.PUT, putUpdateUser);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
        Assert.assertEquals(response.getStatusCode(), 204);
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertEquals(jsonPathEvaluator.get("status"), "success");
        Assert.assertEquals(jsonPathEvaluator.get("message"), "User "+user+" added with updated score");
    }

    @Test
    public void test_09_verifyDeleteUserInvalidUser_401() {
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", JWT_TOKEN+"12");
        request.header("Accept", "application/json");
        request.header("Content-Type", "application/json");
        Response response = request.request(Method.DELETE, deleteUser);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
        Assert.assertEquals(response.getStatusCode(), 401);
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertEquals(jsonPathEvaluator.get("error"), "unable to authenticate key");
    }

    @Test
    public void test_10_verifyDeleteUserUser_204() {
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", JWT_TOKEN);
        request.header("Accept", "application/json");
        request.header("Content-Type", "application/json");
        request.header("delete-key", "ArpitCBA");
        Response response = request.request(Method.DELETE, deleteUser);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
        Assert.assertEquals(response.getStatusCode(), 204);
    }
}
