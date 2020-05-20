package com.mkyong.common.controller;

import com.mkyong.common.controller.commonenum.ResponseCode;
import com.mkyong.common.controller.database.JdbcCustomerDAO;
import com.mkyong.common.controller.encryption.AES;
import com.mkyong.common.controller.model.*;

public class SSLService {

    private JdbcCustomerDAO jdbcCustomerDAO;

    public SSLService(JdbcCustomerDAO jdbcCustomerDAO) {
        this.jdbcCustomerDAO = jdbcCustomerDAO;
    }

    public AltitudeResponseToken postSSLRequest(LoginModel loginModel) {
        AltitudeResponseToken data = new AltitudeResponseToken();

        /*Check Reference ID and Merchant key
         * If there is no entity bye Reference ID and Merchant key go to next Step
         * */
        LoginDataModel dbLoginModel = jdbcCustomerDAO.findByCustomerId(loginModel.getSslRefId(), loginModel.getMerchantKey());
        if (dbLoginModel == null) {
            LoginDataModel dataModel = convertLoginModelToDataModel(loginModel);
            jdbcCustomerDAO.insert(dataModel);
            data = this.postSSL(loginModel);
        }
        return data;
    }


    /*There is two post call here
     *First call for Authentication Header by ALTITUDE username and password
     * Then call api to check password valid
     * */
    public AltitudeResponseToken postSSL(LoginModel loginModel) {
        AltitudeLoginRequest altitudeLoginRequest = new AltitudeLoginRequest("", "");
        AltitudeLoginResponse loginResponse = altitudeLoginPost(altitudeLoginRequest);
        if (loginResponse.getResponseCode() == ResponseCode.OPERATION_SUCCESSFULL.getCode()) {
            MerchantLoginRequest merchantLoginRequest = new MerchantLoginRequest(loginModel.getMerchantKey());
            MerchantLoginResponse merchantResponse = merchantKeyVerification(merchantLoginRequest, loginResponse.getData().getAccessToken());
            if (merchantResponse.getResponseCode() == ResponseCode.OPERATION_SUCCESSFULL.getCode()) {
                return loginResponse.getData();
            }
        }
        return new AltitudeResponseToken();
    }

    /*
     * call api to check merchant password valid
     * POST  /api/v1/merchant/credential/verification
     * */
    private MerchantLoginResponse merchantKeyVerification(MerchantLoginRequest merchantLoginRequest, String accessToken) {
//        TODO: Have To implement RestTemplate
        MerchantLoginResponse response = new MerchantLoginResponse();
        response.setData(true);
        response.setResponseCode(ResponseCode.OPERATION_SUCCESSFULL.getCode());
        return response;
    }

    /*call for Authentication Header by ALTITUDE username and password
    *login-controller
    *POST   URL /api/v1/user/login
     * */
    private AltitudeLoginResponse altitudeLoginPost(AltitudeLoginRequest altitudeLoginRequest) {
        //        TODO: Have To implement RestTemplate
        AltitudeResponseToken response = new AltitudeResponseToken();
        response.setAccessToken("abcdereikkld");
        AltitudeLoginResponse altitudeLoginResponse = new AltitudeLoginResponse();
        altitudeLoginResponse.setData(response);
        altitudeLoginResponse.setResponseCode(ResponseCode.OPERATION_SUCCESSFULL.getCode());
        return altitudeLoginResponse;
    }

    private LoginDataModel convertLoginModelToDataModel(LoginModel loginModel) {
        LoginDataModel dataModel = new LoginDataModel(loginModel.getMerchantKey(), "", loginModel.getSslRefId(),
                Double.valueOf(AES.decrypt(loginModel.getProductPrice())), AES.decrypt(loginModel.getMerchantName()));
        return dataModel;
    }

    public IBLoginResponseModel postIBLogin(IBLoginModel loginModel) {
        return new IBLoginResponseModel();
        /*
        WebClient client = WebClient.create("http://localhost:8080");
        client.path("/merchant/rest/token");
        client.type("application/json").accept("application/json");
        Response r = client.post(loginModel);
        IBLoginResponseModel response = r.readEntity(IBLoginResponseModel.class);
        return response;*/
    }
}
