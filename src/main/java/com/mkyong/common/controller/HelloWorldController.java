package com.mkyong.common.controller;

import com.mkyong.common.controller.restclient.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldController extends AbstractController{

    private SSLService sslService;

    public HelloWorldController(SSLService sslService) {
        this.sslService =sslService;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        ALoginRequestModel loginModel = new ALoginRequestModel("altitude","altitude123");
        JasonRequestResponse<ALoginResponseModel> jasonRequestResponse = new JasonRequestResponse<ALoginResponseModel>(new ALoginResponseModel());
        ALoginResponseModel str = jasonRequestResponse.post(CommonService.convertObjectModelToJson(loginModel));
        System.out.println(str);
        ModelAndView model = new ModelAndView("HelloWorldPage");
        model.addObject("msg", str == null ? "Null Value":str.getData().getAccessToken()+str.getResponseCode());

        return model;
    }

}