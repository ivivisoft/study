package com.ivivisoft.model.login;

import java.io.Serializable;


public class UserBean implements Serializable {
    private int hasSetPayPwd;
    private String userName;
    private int bankNum;
    private String mobilePhone;
    private int realname_status;
    private String _token;
    private int userId;

    public int getHasSetPayPwd() {
        return hasSetPayPwd;
    }

    public void setHasSetPayPwd(int hasSetPayPwd) {
        this.hasSetPayPwd = hasSetPayPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getBankNum() {
        return bankNum;
    }

    public void setBankNum(int bankNum) {
        this.bankNum = bankNum;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public int getRealname_status() {
        return realname_status;
    }

    public void setRealname_status(int realname_status) {
        this.realname_status = realname_status;
    }

    public String get_token() {
        return _token;
    }

    public void set_token(String _token) {
        this._token = _token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

