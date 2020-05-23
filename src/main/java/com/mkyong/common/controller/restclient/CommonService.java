package com.mkyong.common.controller.restclient;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class CommonService {

    public static String convertObjectModelToJson(Object object) {
        ObjectMapper Obj = new ObjectMapper();
        try {
            // get Oraganisation object as a json string
            String jsonStr = Obj.writeValueAsString(object);
            // Displaying JSON String
            System.out.println(jsonStr);
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
