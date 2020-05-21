package com.example.demo.util;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.UserToken;

public class WebContextUtil {
	 
	 
    //本地线程缓存token
    private static ThreadLocal<String> local = new ThreadLocal<>();
 
 
    /**
     * 设置token信息
     * @param content
     */
    public static void setUserToken(String content){
        removeUserToken();
        local.set(content);
    }
 
 
    /**
     * 获取token信息
     * @return
     */
    public static UserToken getUserToken(){
        if(local.get() != null){
            UserToken userToken = JSONObject.parseObject(local.get() , UserToken.class);
            return userToken;
        }
        return null;
    }
 
 
    /**
     * 移除token信息
     * @return
     */
    public static void removeUserToken(){
        if(local.get() != null){
            local.remove();
        }
    }
}