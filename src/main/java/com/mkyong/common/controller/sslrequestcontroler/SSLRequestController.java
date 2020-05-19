package com.mkyong.common.controller.sslrequestcontroler;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SSLRequestController extends AbstractController {


   /* @GetMapping("/ssl-login")
    public String greeting(Model model) {
        LoginModel loginModel = new LoginModel();
        model.addAttribute("loginModel", loginModel);
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "sslLogin";
    }

    @PostMapping("/ssl-login")
    public String postSSL(@ModelAttribute LoginModel loginModel, ModelMap model) {
        //LoginResponseModel response = restTemplate.postUserModel(loginModel);
        LoginResponseModel response = new LoginResponseModel();
        response.setTransactionId("dfwioejdsvfs");
        model.addAttribute("transactionId", response.getTransactionId());
        return "ibLogin";
    }*/

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView("sslLogin");
        return modelAndView;
    }

   /* @GetMapping("/ibs_payment/billLogin")
    public String iblogin(Model model) {
        return "sslLogin";
    }*/
}
