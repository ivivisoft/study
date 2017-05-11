package com.ivivisoft.api.util;

import org.json.JSONObject;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dafei on 2017/4/19.
 */
public class StringUtil {
    public static String map2Json(Map<String,String> map){
        JSONObject obj=new JSONObject(map);
        return obj.toString();
    }

    // 正则表达式判断密码是否符合格式
    public static boolean checkPwd(String name) {
        if (name.length() >= 8 && name.length() <= 16) {
            Pattern p1 = Pattern.compile("[a-zA-Z]+");
            Pattern p2 = Pattern.compile("[0-9]+");
            Matcher m = p1.matcher(name);
            if (!m.find()) {
                return false;
            } else {
                // m = p2.matcher(name);
                m.reset().usePattern(p2);
                return m.find();
            }
        } else {
            return false;
        }
    }
}
