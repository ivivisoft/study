package com.ivivisoft.api.login;

import com.ivivisoft.api.ApiResponse;
import com.ivivisoft.model.login.UserBean;

/**
 * Created by andy on 2017/5/9.
 */

public interface LoginApi {


    ApiResponse<UserBean> requestLogin(String phone, String password, String device_id);


}
