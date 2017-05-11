package com.ivivisoft.core.login;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.Settings;
import android.text.TextUtils;

import com.ivivisoft.api.ApiResponse;
import com.ivivisoft.api.login.LoginApi;
import com.ivivisoft.api.login.LoginApiImpl;
import com.ivivisoft.core.ActionCallbackListener;
import com.ivivisoft.core.BaseAppActionImpl;
import com.ivivisoft.core.ErrorEvent;
import com.ivivisoft.core.util.UtilTool;
import com.ivivisoft.model.login.UserBean;

/**
 * Created by andy on 2017/5/11.
 */

public class LoginActionImpl extends BaseAppActionImpl implements LoginAction {
    private Context context;
    private LoginApi loginApi;
    final private String device_id;

    public LoginActionImpl(Context context) {
        this.context = context;
        this.loginApi = new LoginApiImpl();
        this.device_id = Settings.Secure.getString(this.context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    @Override
    public void requestLogin(final String phone, final String password, final ActionCallbackListener<UserBean> listener) {
        if (TextUtils.isEmpty(phone)) {
            if (listener != null) {
                listener.onFailure(ErrorEvent.PARAM_NULL, "手机号为空");
            }
            return;
        }
        //手机号码正则验证
        if (!UtilTool.checkIphoneNumber(phone)) {
            if (listener != null) {
                listener.onFailure(ErrorEvent.PARAM_ILLEGAL, "手机号不合法");
            }
            return;
        }
        if (TextUtils.isEmpty(password)) {
            if (listener != null) {
                listener.onFailure(ErrorEvent.PARAM_NULL, "密码为空");
            }
            return;
        }

        new AsyncTask<Void, Void, ApiResponse<UserBean>>() {
            @Override
            protected ApiResponse<UserBean> doInBackground(Void... voids) {
                return loginApi.requestLogin(phone, password,device_id);
            }

            @Override
            protected void onPostExecute(ApiResponse<UserBean> response) {
                if (listener != null && response != null) {
                    if (response.isSuccess()) {
                        listener.onSuccess(response.getData());
                    } else {
                        listener.onFailure(response.getCode(), response.getMsg());
                    }
                }
            }
        }.execute();

    }
}

