package com.example.demo.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserToken implements Serializable {
 
 
    private static final long serialVersionUID = 1L;
 
 
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
    
    
	private String email;

}