package com.mkyong.common.controller.database;

import com.mkyong.common.controller.model.LoginModel;
import com.mkyong.common.controller.model.LoginResponseModel;

public interface CustomerDAO
{
    public void insert(LoginModel customer);
    public LoginModel findByCustomerId(int custId);
}