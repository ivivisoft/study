package com.ivivisoft.api.login;

import android.util.Base64;

import com.google.gson.reflect.TypeToken;
import com.ivivisoft.api.ApiResponse;
import com.ivivisoft.api.BaseApiImpl;
import com.ivivisoft.model.Contents;
import com.ivivisoft.model.login.UserBean;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andy on 2017/5/9.
 */
public class LoginApiImpl extends BaseApiImpl implements LoginApi {

    @Override
    public ApiResponse<UserBean> requestLogin(String phone, String password, String device_id) {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("device_name", android.os.Build.MANUFACTURER);
        paramMap.put("device_id", device_id);
        paramMap.put("mobile", phone);
        paramMap.put("pwd", Base64.encodeToString(password.getBytes(), Base64.DEFAULT));
        Type type = new TypeToken<ApiResponse<UserBean>>() {
        }.getType();
        return this.httpEngine.postHandle(Contents.SERVER_URL, paramMap, type);
    }

}
