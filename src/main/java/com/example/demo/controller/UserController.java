package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.config.JwtIgnore;
import com.example.demo.entity.Students;
import com.example.demo.entity.UserToken;
import com.example.demo.entity.UserVO;
import com.example.demo.util.JwtTokenUtil;
import com.example.demo.util.WebContextUtil;

@RestController
public class UserController {
	
	/**
	 * 登录
	 * @param userDto
	 * @return
	 */
	@JwtIgnore
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	public UserVO login(@RequestBody UserVO vo, HttpServletResponse response){
	    //...参数合法性验证
	 
	    //从数据库获取用户信息
	    //UserVO dbUser = userService.selectByUserNo(vo.getUserNo);
		vo.setUserId("sssssaa111");
		vo.setUserName("kone");
		vo.setUserNo("001");
	    //....用户、密码验证
	 
	    //创建token，并将token放在响应头
	    UserToken userToken = new UserToken();
	    BeanUtils.copyProperties(vo,userToken);
	 
	 
	    String token = JwtTokenUtil.createToken(JSONObject.toJSONString(userToken));
	    response.setHeader(JwtTokenUtil.AUTH_HEADER_KEY, token);
	 
	    vo.setPassword("");
	    //定义返回结果
	    return vo;
	}
	@RequestMapping(value = "/students/{number}",method = RequestMethod.GET)
	public List<Students> getStudents(@PathVariable  int number) throws InterruptedException{
		UserToken usersss = WebContextUtil.getUserToken();
		System.out.println(usersss);
		//System.out.println(number+"开始");
		//Thread.sleep(5000);
		List<Students> list = new ArrayList<Students>();
		for(int i=0;i<number;i++) {
			Students s= new Students("name"+(i+1),18+i, i%2==0?'男':'女');
			list.add(s);
		}
		//System.out.println(number+"生成并返回"+number+"个students。");
		return list;
	}
}
