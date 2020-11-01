package apiTesting;

import apiTestingAuxClasses.RequestMaker;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.testng.annotations.Test;
import utils.GlobalVariables;

public class GetMethodsUsers {

    @Test(groups = {"all", "getMethods", "getAllUsers"}, description = "getAllUsers API")
    public void getAllUsers() {
        Response response = RequestMaker.makeGetRequest(GlobalVariables.getMethodsApiHost);
        String resposeString = response.asString();
        JSONArray  jsonResponse =  new JSONArray(resposeString);
        System.out.println(jsonResponse.toString(10));
    }
}