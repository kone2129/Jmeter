package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class UserVO {
	
	private String email;
	private String password;
	
    /**
     * 用户ID
     */
    private String userId;
 
 
    /**
     * 用户登录账户
     */
    private String userNo;
 
 
    /**
     * 用户中文名
     */
    private String userName;
	
}
