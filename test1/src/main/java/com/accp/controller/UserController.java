package com.accp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Address;
import com.accp.domain.User;
import com.accp.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/find")
	public String find() {
		return "user";
	}
	
	/**
	 * 查询数据
	 * @param id
	 * @return
	 */
	@GetMapping("/findbyData")
	@ResponseBody
	public User findByData(Integer id) {
		List<User> u=service.findByid(id);
		User user=u.get(0);
		List<Address> add=service.findByDz(user.getUserid());
		String address=add.get(add.size()-1).getAddress();
		user.setAddress(address);
		user.setAddressid(add.get(add.size()-1).getId());
		return user;
	}
	
	
	/**
	 * 保存数据并判断
	 * @param u
	 * @return
	 */
	@PostMapping("/insert")
	@ResponseBody
	public String insert(@RequestBody User u) {
		List<User> user=service.find();
		User u1=new User();
		for (User user2 : user) {
			if(user2==u) {
				u1=u;
			}
		}
		if(u1==null) {
			Address ress=new Address();
			ress.setAddress(u1.getAddress());
			ress.setUserid(u1.getUserid());
			service.insert(u1);
			service.insertdz(ress);
			return "0000";
		}else {
			Address ress=service.findbydzid(u.getAddressid());
			if(ress==null) {
				System.out.println(u.getAddress());
				Address ress1=new Address();
				ress1.setId(u.getAddressid());
				ress1.setAddress(u.getAddress());
				ress1.setUserid(u.getUserid());
				service.insertdz(ress1);
				return "0001";
			}else {
				Address ress1=new Address();
				ress1.setId(u.getAddressid());
				ress1.setAddress(u.getAddress());
				ress1.setUserid(u.getUserid());
				service.update(u);
				service.updatedz(ress1);
				return "0002";
			}
		}
	}
}
