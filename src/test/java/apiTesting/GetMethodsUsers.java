package apiTesting;

import apiTestingAuxClasses.RequestMaker;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.testng.annotations.Test;

public class GetMethodsUsers {

    @Test(groups = {"all", "getMethods", "getAllUsers"}, description = "getAllUsers API")
    public void getAllUsers() {
        String url = "http://localhost:5000/users/all";
        Response response = RequestMaker.makeGetRequest(url);
        String resposeString = response.asString();
        JSONArray  jsonResponse =  new JSONArray(resposeString);
        System.out.println(jsonResponse.toString(10));
    }
}