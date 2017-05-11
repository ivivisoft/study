package com.ivivisoft.core.login;

import com.ivivisoft.core.ActionCallbackListener;
import com.ivivisoft.core.BaseAction;
import com.ivivisoft.model.login.UserBean;

/**
 * Created by andy on 2017/5/11.
 */

public interface LoginAction extends BaseAction {
    // 登录
    void requestLogin(String phone,String password,ActionCallbackListener<UserBean> listener);
}

