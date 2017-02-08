package www.yunpan.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.yunpan.com.db.IUserDao;
import www.yunpan.com.entity.UserEntity;
import www.yunpan.com.service.IUserService;

@Service
public class IUserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	public void insertUser(UserEntity user) {
		userDao.insertUser(user);

	}

	public void updateUser(UserEntity user) {
		userDao.updateUser(user);

	}

	public void deleteUser(String id) {
		userDao.deleteUser(id);

	}

	public UserEntity findUserById(String id) {
		
		return userDao.findUserById(id);
	}

	public List<UserEntity> findAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserEntity login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
