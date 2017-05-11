package com.ivivisoft.study.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.ivivisoft.study.StudyApplication;

/**
 * Created by andy on 2017/5/11.
 */

public abstract class StudyBaseActivity extends FragmentActivity {
    // 应用全局的实例
    public StudyApplication application;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.application = (StudyApplication) this.getApplication();
    }

}
