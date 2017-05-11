package com.ivivisoft.study.activity.login;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ivivisoft.core.ActionCallbackListener;
import com.ivivisoft.core.login.LoginAction;
import com.ivivisoft.core.login.LoginActionImpl;
import com.ivivisoft.model.login.UserBean;
import com.ivivisoft.study.R;
import com.ivivisoft.study.activity.StudyBaseActivity;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * Created by andy on 2017/5/11.
 */

public class LoginActivity extends StudyBaseActivity {
    private LoginAction loginAction;
    private TextView tv_forget_pwd, tv_newuser_reg;
    private ImageView iv_back, register_iv_code;
    private MaterialEditText et_phone, et_pwd, et_code;
    private RelativeLayout relay_code;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //初始化action
        this.loginAction = new LoginActionImpl(LoginActivity.this);
        // 初始化View
        initViews();

    }


    // 初始化View
    private void initViews() {
        tv_forget_pwd = (TextView) findViewById(R.id.tv_forget_pwd);
        tv_newuser_reg = (TextView) findViewById(R.id.tv_newuser_reg);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        et_phone = (MaterialEditText) findViewById(R.id.et_phone);
        et_pwd = (MaterialEditText) findViewById(R.id.et_pwd);
        et_code = (MaterialEditText) findViewById(R.id.et_code);
        relay_code = (RelativeLayout) findViewById(R.id.relay_code);
        btn_login = (Button) findViewById(R.id.btn_login);
        register_iv_code = (ImageView) findViewById(R.id.register_iv_code);
        tv_newuser_reg.setText(Html.fromHtml("新用户?<font color='#f2774d'>立即注册</font>"));
    }

    public void requestLogin(View view) {
        String phone = et_phone.getText().toString();
        String pwd = et_pwd.getText().toString();
        btn_login.setEnabled(false);
        this.loginAction.requestLogin(phone, pwd, new ActionCallbackListener<UserBean>() {

            @Override
            public void onSuccess(UserBean data) {
                Toast.makeText(LoginActivity.this, "ddddd", Toast.LENGTH_SHORT).show();

                finish();
            }

            @Override
            public void onFailure(String code, String message) {
                Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                btn_login.setEnabled(true);
            }
        });

    }


}
