package com.mkyong.common.controller.sslrequestcontroler;

import com.mkyong.common.controller.SSLService;
import com.mkyong.common.controller.model.IBLoginModel;
import com.mkyong.common.controller.model.IBLoginResponseModel;
import com.mkyong.common.controller.model.LoginModel;
import com.mkyong.common.controller.model.LoginResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

public class IBankingLoginControllerPost extends AbstractController {

    @Autowired
    HttpSession httpSession;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        LoginModel loginModel = (LoginModel) httpSession.getAttribute("loginModel");

        ModelAndView modelAndView ;
        String userName = httpServletRequest.getParameter("userName");
        String password = httpServletRequest.getParameter("password");
        String sslRefId  = String.valueOf(new Date());
        double productPrice  = Double.valueOf(httpServletRequest.getParameter("productPrice").trim());
        IBLoginModel ibLoginModel = new IBLoginModel(userName,password,sslRefId,productPrice);
        SSLService service = new SSLService();
        IBLoginResponseModel responseModel = service.postIBLogin(ibLoginModel);
        responseModel.setResponseCode(100);
        responseModel.setMessage("Operation Successful");
        if(responseModel.getResponseCode() == 100){
            modelAndView = new ModelAndView("success");
            modelAndView.addObject("message", responseModel.getMessage());
            return modelAndView;
        }
        modelAndView = new ModelAndView("pbankiloginpage");
        return modelAndView;
    }

}
