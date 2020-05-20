package com.mkyong.common.controller.sslrequestcontroler;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SSLRequestController extends AbstractController {
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
