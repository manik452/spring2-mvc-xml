package com.mkyong.common.controller.restclient;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkyong.common.controller.model.LoginModel;
import org.apache.http.client.ClientProtocolException;

public class Test extends CommonService {
    public static void main(String[] args) throws ClientProtocolException, IOException {

/*        JasonRequestResponse<LoginResponseModel> jasonRequestResponse = new JasonRequestResponse<LoginResponseModel>(new LoginResponseModel());
        LoginResponseModel str = jasonRequestResponse.get();
//       jasonRequestResponse.getTest();
        System.out.println(str);*/
        LoginRequest loginModel = new LoginRequest("jamal","belal");
        JasonRequestResponse<LoginResponseModel> jasonRequestResponse = new JasonRequestResponse<LoginResponseModel>(new LoginResponseModel());
        LoginResponseModel str = jasonRequestResponse.post(convertObjectModelToJson(loginModel));
        System.out.println(str);

       /* HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://localhost:8081/users/2");
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }*/
       /* ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri("http://restUrl").build());
        Form form = new Form();
        form.add("name1", "value1");
        form.add("name2", "value1");
        ClientResponse response = service.path("restPath").path("resourcePath").
                type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, form);
        System.out.println("Response " + response.getEntity(String.class));*/
    }

    private static String convertToJson(LoginRequest loginModel) {
        ObjectMapper Obj = new ObjectMapper();
        try {
            // get Oraganisation object as a json string
            String jsonStr = Obj.writeValueAsString(loginModel);
            // Displaying JSON String
            System.out.println(jsonStr);
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}