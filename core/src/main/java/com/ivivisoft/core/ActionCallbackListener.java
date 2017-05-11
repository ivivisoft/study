package com.ivivisoft.core;

/**
 * Created by andy on 2017/5/11.
 */

public interface ActionCallbackListener<T> {
    /**
     * 成功时调用
     *
     * @param data 返回的数据
     */
    void onSuccess(T data);

    /**
     * 失败时调用
     *
     * @param code    错误码
     * @param message 错误信息
     */
    void onFailure(String code, String message);

}
