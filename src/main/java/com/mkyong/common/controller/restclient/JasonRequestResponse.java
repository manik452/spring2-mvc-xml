package com.mkyong.common.controller.restclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkyong.common.controller.model.LoginModel;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class JasonRequestResponse {
    public static void getJsonObjectRequest() {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8081/users/1").build());
        // getting XML data
        System.out.println(service.path("restPath").path("resourcePath").accept(MediaType.APPLICATION_JSON).get(String.class));
        // getting JSON data
//        System.out.println(service. path('restPath').path('resourcePath').accept(MediaType.APPLICATION_XML).get(String.class));

        return;
    }

    public static void sendStringPost() {

        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost("http://localhost:8081/users/str");
            StringEntity input = null;

            input = new StringEntity("name");
            post.setEntity(input);
            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static LoginResponseModel jsonObjectToObject() {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource webResource = client.resource(UriBuilder.fromUri("http://localhost:8081/user/1").build());
        String str = convertObjectToJSON();
        MultivaluedMap formData = new MultivaluedMapImpl();
        formData.add("userName", "dfdj");
        formData.add("password", "dfdj");
//        ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).post(ClientResponse.class, formData);
//        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, new JasonRequestResponse());

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, str);
//       System.out.println("Response " + response.getEntity(String.class));
        LoginResponseModel loginResponseModel = convertJSONToObject(response.getEntity(String.class));
        return response.getEntity(LoginResponseModel.class);
    }

    private static String convertObjectToJSON() {

        LoginRequest loginRequest = new LoginRequest("Manik", "sdfj");
        ObjectMapper Obj = new ObjectMapper();

        try {

            // get Oraganisation object as a json string
            String jsonStr = Obj.writeValueAsString(loginRequest);


            // Displaying JSON String
            System.out.println(jsonStr);
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static LoginResponseModel convertJSONToObject(String jsonInString) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            //JSON from String to Object
            LoginResponseModel user = mapper.readValue(jsonInString, LoginResponseModel.class);

            return user;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new LoginResponseModel("null");
    }


}
