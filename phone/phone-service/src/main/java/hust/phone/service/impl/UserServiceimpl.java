package hust.phone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hust.phone.mapper.mapper.UserMapper;
import hust.phone.mapper.pojo.User;
import hust.phone.service.interFace.UserService;
@Service
public class UserServiceimpl  implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserById(String userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		return user;
	}

}
