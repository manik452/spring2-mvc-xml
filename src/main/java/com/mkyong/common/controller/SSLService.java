package com.mkyong.common.controller;

import com.mkyong.common.controller.database.JdbcCustomerDAO;
import com.mkyong.common.controller.model.IBLoginModel;
import com.mkyong.common.controller.model.IBLoginResponseModel;
import com.mkyong.common.controller.model.LoginModel;
import com.mkyong.common.controller.model.LoginResponseModel;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class SSLService {

    private JdbcCustomerDAO jdbcCustomerDAO;

    public SSLService(JdbcCustomerDAO jdbcCustomerDAO) {
        this.jdbcCustomerDAO = jdbcCustomerDAO;
    }

    public LoginResponseModel postSSLRequest(LoginModel loginModel) {
        LoginResponseModel loginResponseModel;

        LoginModel dbLoginModel = jdbcCustomerDAO.findByCustomerId(loginModel.getSslRefId(), loginModel.getMerchantKey());
        if (dbLoginModel == null) {
            jdbcCustomerDAO.insert(loginModel);
            loginResponseModel = this.postSSL(loginModel);
            createDB(loginResponseModel);
        } else {
            loginResponseModel = new LoginResponseModel();
            loginResponseModel.setPaymentStatus(101);
            loginResponseModel.setStatusMessage("Reference Id Already Exist");
        }
        return loginResponseModel;
    }

    private void createDB(LoginResponseModel loginResponseModel) {


    }

    public LoginResponseModel postSSL(LoginModel loginModel) {
        LoginResponseModel loginResponseModel = new LoginResponseModel();
        loginResponseModel.setPaymentStatus(100);
        return loginResponseModel;
        /*WebClient client = WebClient.create("http://localhost:8080");
        client.path("/merchant/rest/token");
        client.type("application/json").accept("application/json");
        Response r = client.post(loginModel);
        LoginResponseModel response = r.readEntity(LoginResponseModel.class);
        return response;*/
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
   /* public BookModel postSSLtest(){
        BookModel bookModel = new BookModel("afdj","dsfjlk","12","1");
        List<Object> providers = new ArrayList<Object>();
        providers.add(new JacksonJsonProvider());
        WebClient client = WebClient
                .create("https://jsonplaceholder.typicode.com/posts", providers);
        client = client.accept("application/json").type("application/json");
        Response r = client.post(bookModel);
        BookModel resp = r.readEntity(BookModel.class);
        return resp;
    }*/

    /*public BookModel postSSLtest2() {
        BookModel bookModel = new BookModel("afdj","dsfjlk","12","1");
        UserRequest req = new UserRequest();
        req.setId("1234578");
        req.setName("kswaughs");

        List<Object> providers = new ArrayList<Object>();
        providers.add(new JacksonJsonProvider());

        WebClient client = WebClient
                .create("http://127.0.0.1:8080/camel-rest-0.0.1-SNAPSHOT/user/add", providers);

        client = client.accept("application/json").type("application/json");

        Response r = client.post(req);
        UserResponse resp = r.readEntity(UserResponse.class);
        System.out.println(resp);
        return new BookModel();
    }*/
   /* RestTemplate restTemplate = new RestTemplate();
    //we can't get List<Employee> because JSON convertor doesn't know the type of
    //object in the list and hence convert it to default JSON object type LinkedHashMap
    List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI+EmpRestURIConstants.GET_ALL_EMP, List.class);
		System.out.println(emps.size());*/
}
