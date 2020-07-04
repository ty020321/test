package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.AddressMapper;
import com.accp.dao.UserMapper;
import com.accp.domain.Address;
import com.accp.domain.AddressExample;
import com.accp.domain.User;
import com.accp.domain.UserExample;
@Service
@Transactional
public class UserService {
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private AddressMapper dmapper;
	
	public List<User> findByid(Integer id) {
		UserExample example=new UserExample();
		example.createCriteria().andUseridEqualTo(id);
		return mapper.selectByExample(example);
	}
	
	public List<User> find(){
		return mapper.selectByExample(null);
	}
	
	public Address findbydzid(Integer id) {
		return dmapper.selectByPrimaryKey(id);
	}
	
	public List<Address> findByDz(Integer id) {
		AddressExample example=new AddressExample();
		example.createCriteria().andUseridEqualTo(id);
		return dmapper.selectByExample(example);
	}
	
	public int update(User u) {
		return mapper.updateByPrimaryKey(u);
	}
	public int updatedz(Address u) {
		return dmapper.updateByPrimaryKey(u);
	}
	
	public int insert(User u) {
		return mapper.insert(u);
	}
	
	public int insertdz(Address add) {
		return dmapper.insert(add);
	}
	
	
}
