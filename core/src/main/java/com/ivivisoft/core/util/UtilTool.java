package com.ivivisoft.core.util;

import android.text.TextUtils;

/**
 * Created by andy on 2017/5/11.
 */

public class UtilTool {
    // 判断手机号是否合法
    public static boolean checkIphoneNumber(String name) {
			/*
			 * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
			 * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
			 * 总结起来就是第一位必定为1，第二位必定为3或5或7或8，其他位置的可以为0-9
			 */
        String telRegex = "[1][34578]\\d{9}";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(name)) {
            return false;
        } else {
            return name.matches(telRegex);
        }
    }
}
