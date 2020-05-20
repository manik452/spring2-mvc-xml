package com.mkyong.common.controller.sslrequestcontroler;

import com.mkyong.common.controller.SSLService;
import com.mkyong.common.controller.encryption.AES;
import com.mkyong.common.controller.model.AltitudeResponseToken;
import com.mkyong.common.controller.model.LoginModel;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class SSLRequestControllerPost extends AbstractController {
    private SSLService sslService;
    public SSLRequestControllerPost(SSLService sslService) {
        this.sslService = sslService;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest,
                                                 HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView;
        String merchantKey = httpServletRequest.getParameter("merchantKey");
//        String sslRefId  = randomValue();
        String sslRefId  = httpServletRequest.getParameter("sslRefId");
        String productPrice  = httpServletRequest.getParameter("productPrice").trim();
        String merchantName = httpServletRequest.getParameter("merchantName");

        /*
         * encrypt Plain Test To Secure data
         * */
        if(validateData(merchantKey,sslRefId,productPrice,merchantName)){
            LoginModel loginModel = converttoSecureDataAESAlgo(merchantKey,sslRefId,
                    productPrice,merchantName);
            AltitudeResponseToken token =  sslService.postSSLRequest(loginModel);
            if(token != null && !"".equals(token)){
                modelAndView =  new ModelAndView("pbankloginpage");
                modelAndView.addObject("message", "");
                modelAndView.addObject("merchantKey", loginModel.getProductPrice());
                modelAndView.addObject("sslRefId", sslRefId);
                modelAndView.addObject("productPrice", productPrice);
                return modelAndView;
            }
        }
        modelAndView =  new ModelAndView("sslLogin");
        modelAndView.addObject("mesage", "Invalid Information");
        return modelAndView;
    }

    private boolean validateData(String merchantKey, String sslRefId,
                                 String productPrice, String merchantName) {
        try {
//            TODO: CHECK OTHER DATA VALIDATION
            double price  = Double.valueOf(productPrice);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private LoginModel converttoSecureDataAESAlgo(String merchantKey, String sslRefId,
                                                  String productPrice, String merchantName) {
        return new LoginModel(AES.encrypt(merchantKey),
                AES.encrypt(sslRefId),
                AES.encrypt(productPrice),
                AES.encrypt(merchantName));
    }

    private String randomValue() {
        return String.valueOf(new Date().getTime());
    }
}
