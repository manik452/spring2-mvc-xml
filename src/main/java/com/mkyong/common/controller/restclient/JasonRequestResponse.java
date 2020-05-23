package com.mkyong.common.controller.restclient;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkyong.common.controller.commonenum.HTTPResponseCode;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;

/*
* BaseModel if restrict the T type.
* when it is Number Then T must be number
* extends is upper bound wildcard
* super is lower bound wildcard
* */
public class JasonRequestResponse<T extends BaseModel> {

    private static final String baseUrl="http://10.100.100.93:8080";
    private static final String userOne="/users/getAllUser";
    private static final String post= "/api/v1/user/login";
    private T type;

    public JasonRequestResponse(T type) {
        this.type = type;
    }

    public T get(){
        T response = null;
        String fullUrl = baseUrl.concat(userOne);
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource webResource = client.resource(UriBuilder.fromUri(fullUrl).build());
        ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);
        if(clientResponse.getStatus() == HTTPResponseCode.OPERATION_SUCCESSFULL.getCode()){
            response = (T) this.convertInstanceOfObjectFromJSONString(type.getClass(),
                    clientResponse.getEntity(String.class));
        }
        return response;
    }

    public T post( String requestJSON){
        T response = null;
        String fullUrl = baseUrl.concat(post);
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource webResource = client.resource(UriBuilder.fromUri(fullUrl).build());
        ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, requestJSON);
        if(clientResponse.getStatus() == HTTPResponseCode.OPERATION_SUCCESSFULL.getCode()){
           response  = (T) this.convertInstanceOfObjectFromJSONString(type.getClass(),
                    clientResponse.getEntity(String.class));
        }

        return response;
    }

    public <T> T convertInstanceOfObjectFromJSONString(Class<T> clazz, String jsonInString) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            T type = mapper.readValue(jsonInString, clazz);
            return type;
        } catch(ClassCastException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (T) clazz;
    }

}
