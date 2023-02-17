package com.dphone.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.dphone.user.bean.UserBean;
import com.dphone.user.dao.UserDao;
import com.dphone.user.entity.UserEntity;

@Service
public class UserDaoImpl {
	
	@Autowired
	private UserDao userdao;
	
	public List<UserEntity> findUser(){
		return userdao.findAll();
		
	}
	public boolean authorizeUser(UserBean userBean) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userBean, userEntity);
		return userdao.existsById(userEntity.getId());
		
	}
//	public void addUser(int id,String firstname, String lastname, String username, String password) {
//		UserEntity userEntity = new UserEntity(id, firstname, lastname, username, password);
//		userdao.save(userEntity);
//	}
	public UserBean addUser(UserBean userBean) {
//		UserEntity userEntity = new UserEntity(id, firstname, lastname, username, password);
//		userEntity.setId(userEntity.getId()+1);
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userBean, userEntity);
		userdao.save(userEntity);
		return userBean;
	}
}
