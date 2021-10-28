package screenless;

import io.restassured.RestAssured;

public class APIHelpers {

    public static String postAuthToken = "/auth/gentoken";
    public static String getVerifyToken = "/auth/verifytoken";
    public static String getUser = "/v1/user";
    public static String postAddUser = "/v1/user";
    public static String putUpdateUser = "/v1/user";
    public static String deleteUser = "/v1/user";

    public APIHelpers(){
        RestAssured.baseURI = "https://supervillain.herokuapp.com";
    }
}
