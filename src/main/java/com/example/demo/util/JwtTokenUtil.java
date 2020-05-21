package com.example.demo.util;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;

public class JwtTokenUtil {
	 
	 
	//定义token返回头部
    public static final String AUTH_HEADER_KEY = "Authorization";
 
 
	//token前缀
    public static final String TOKEN_PREFIX = "Bearer ";
 
 
	//签名密钥
    public static final String KEY = "konemxl";
	
	//有效期默认为 2hour
    public static final Long EXPIRATION_TIME = 1000L*60*60*2;
 
 
 
 
    /**
     * 创建TOKEN
     * @param content
     * @return
     */
    public static String createToken(String content){
        return TOKEN_PREFIX + JWT.create()
                .withSubject(content)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(KEY));
    }
 
 
    /**
     * 验证token
     * @param token
     */
    public static String verifyToken(String token)  {
        try {
            return JWT.require(Algorithm.HMAC512(KEY))
                    .build()
                    .verify(token.replace(TOKEN_PREFIX, ""))
                    .getSubject();
        } catch (TokenExpiredException e){
        	System.out.println("失效");
            //throw new Exception("token已失效，请重新登录",e);
        } catch (JWTVerificationException e) {
        	System.out.println("验证失败");
           // throw new Exception("token验证失败！",e);
        }catch (Exception e) {
        	//System.out.println("Excepationsssssssssssssssss");
        	//throw new Exception("Excepationsssssssssssssssss:",e);
		}
		return token;
    }
}