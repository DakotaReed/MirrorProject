package helper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TempAPI {
    static String url = "http://localhost:3000/";

    public static RequestSpecification httpRequest;
    public static Response response;
    public static JsonPath jp;
    public static JSONObject params;

    @Test
    public static void testingAPI() {
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given().auth().preemptive().basic("admin", "admin1");
        httpRequest.header("Content-Type", "application/json");

        //----Get Request----
        response = httpRequest.get("/api/teams/search?name=Kuku");

        //----Post + Put + Delete Request----
//        params = new JSONObject();
//        params.put("name", "Bteam");
//        params.put("email", "bteam@kuku.com");

//        httpRequest.body(params.toJSONString());
//        response = httpRequest.post("/api/teams");
//        response = httpRequest.put("/api/teams/3");
//        response = httpRequest.delete("/api/teams/2");

        response.prettyPrint();
    }

}
