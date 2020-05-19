package com.mkyong.common.controller.sslrequestcontroler;

import com.mkyong.common.controller.SSLService;
import com.mkyong.common.controller.model.LoginModel;
import com.mkyong.common.controller.model.LoginResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

public class SSLReqSimpleFormControllerPost extends SimpleFormController {

    @Autowired
    HttpSession httpSession;

private SSLService sslService;
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView;
        String merchantKey = httpServletRequest.getParameter("merchantKey");
        String merchantPassword = httpServletRequest.getParameter("merchantPassword");
        String sslRefId  = String.valueOf(new Date());
        double productPrice  = Double.valueOf(httpServletRequest.getParameter("productPrice").trim());
        String merchantName = httpServletRequest.getParameter("merchantName");
        LoginModel loginModel = new LoginModel(merchantKey,merchantPassword,sslRefId,productPrice,merchantName);
        httpSession.setAttribute("loginModel", loginModel);


        LoginResponseModel loginResponseModel =  sslService.postSSLRequest(loginModel);
        if(loginResponseModel.getPaymentStatus() == 100){
            modelAndView =  new ModelAndView("pbankloginpage");
            modelAndView.addObject("message", loginResponseModel.getStatusMessage());
            modelAndView.addObject("productPrice", loginModel.getProductPrice());
            return modelAndView;
        }
        modelAndView =  new ModelAndView("sslLogin");
        return modelAndView;
    }

}
