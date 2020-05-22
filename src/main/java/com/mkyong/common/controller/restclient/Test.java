package com.mkyong.common.controller.restclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Test {
    public static void main(String[] args) throws ClientProtocolException, IOException {

        LoginResponseModel str = JasonRequestResponse.jsonObjectToObject();
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
}