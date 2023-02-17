package com.dphone.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dphone.user.bean.UserBean;
import com.dphone.user.entity.UserEntity;
import com.dphone.user.service.UserDaoImpl;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserDaoImpl userDaoImpl;
	
//	@RequestMapping("/get-user")
//	public String getUser() {
//		return "index";
//	}
	@GetMapping(value="test")
	public String test() {
		return "Its just test";
	}
	@PostMapping(value="/get-user")
	public ResponseEntity<String> authorizeUser(@RequestBody UserBean userBean) {
//		System.out.println(username);
//		System.out.println(password);
		System.out.println(userBean);
		String msg="Its done";
		
//		boolean in= userDaoImpl.authorizeUser(userBean);
//			if(in)
//			{
//				msg="Logged in successfully";
//			}
//			else {
//			msg="Can't find an account with that username.";
//			}
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
}
//	
//	@RequestMapping("/add-user")
//	public String add() {
//		return "sign-up";
//	}
//	@PostMapping("/add")
//	public ResponseEntity<String> addUser(@RequestParam String firstname,@RequestParam String lastname,@RequestParam String username,@RequestParam String password) {
//		List<UserEntity> id = userDaoImpl.findUser();
//		int tid=id.size()+1;
//		System.out.println(tid);
//		UserEntity userEntity=new UserEntity(tid,firstname,lastname,username,password);
//		String msg = userDaoImpl.addUser(userEntity);
//		return new ResponseEntity<String>(msg,HttpStatus.OK);
//	}
	
	
	@PostMapping(value="/add")
	@ResponseBody
	public ResponseEntity<UserBean> addUser(@RequestBody UserBean userBean) {
//		UserBean userBean=new UserEntity(tid,firstname,lastname,username,password);
		UserBean info = userDaoImpl.addUser(userBean);
		return new ResponseEntity<UserBean>(info,HttpStatus.OK);
	}
	
}
