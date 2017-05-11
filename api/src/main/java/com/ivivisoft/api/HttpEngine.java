package com.ivivisoft.api;

import com.google.gson.Gson;
import com.ivivisoft.api.util.StringUtil;
import com.ivivisoft.model.Contents;
import com.zhy.http.okhttp.OkHttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by andy on 2017/5/9.
 */

public class HttpEngine {
    private static HttpEngine instance = null;

    private HttpEngine() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }


    public static HttpEngine getInstance() {
        if (instance == null) {
            instance = new HttpEngine();
        }
        return instance;
    }

    public <T> T postHandle(String url, Map<String, String> paramsMap, Type typeOfT){
        T t = null;
        try {
            Response response = OkHttpUtils.postString()
                    .url(url)
                    .addHeader("version", Contents.version)
                    .content(StringUtil.map2Json(paramsMap)).build().execute();
            if (response != null) {
                String result = new String(response.body().string());
                Gson gson = new Gson();
                try {
                    t = gson.fromJson(result, typeOfT);
                } catch (Exception e) {
                    try {
                        JSONObject obj = new JSONObject(result);
                        t = (T) new ApiResponse(obj.getString("code"), obj.getString("msg"));
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            t = (T) new ApiResponse("500", "调用服务接口异常!");
        }
        return t;
    }

    public <T> T postHandleWithToken(String url, String token, Map<String, String> paramsMap, Type typeOfT) throws IOException {
        Response response = OkHttpUtils.postString()
                .url(url)
                .addHeader("version", Contents.version)
                .addHeader("token", token)
                .content(StringUtil.map2Json(paramsMap)).build().execute();
        String result = new String(response.body().string());
        Gson gson = new Gson();
        return gson.fromJson(result, typeOfT);
    }
}
