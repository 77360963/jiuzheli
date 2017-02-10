package www.yunpan.com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.yunpan.com.db.IRoleDao;
import www.yunpan.com.db.IUserDao;
import www.yunpan.com.db.IUserRoleDao;
import www.yunpan.com.domain.RoleDomain;
import www.yunpan.com.domain.UserDomain;
import www.yunpan.com.entity.RoleEntity;
import www.yunpan.com.entity.UserEntity;
import www.yunpan.com.entity.UserRoleEntity;
import www.yunpan.com.service.IUserService;

@Service
public class IUserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IRoleDao roleDao;
	
	@Autowired
	private IUserRoleDao userRoleDao;

	public void insertUser(UserEntity user) {
		userDao.insertUser(user);

	}

	public void updateUser(UserEntity user,String[] roleIds) {
		userRoleDao.deleteUserRole(user.getId());
		//userDao.updateUser(user);
		if(null!=roleIds){
			for(String roleId:roleIds){
				UserRoleEntity userRoleEntity=new UserRoleEntity();
				userRoleEntity.setRoleId(roleId);
				userRoleEntity.setUserId(user.getId());
				userRoleDao.insertUserRole(userRoleEntity);
			}
		}

	}

	public void deleteUser(String id) {
		userDao.deleteUser(id);

	}

	public UserDomain findUserById(String id) {
		UserEntity userEntity=userDao.findUserById(id);		
		UserDomain userDomain=new UserDomain();
		List<RoleDomain> roles=new ArrayList<RoleDomain>();
		BeanUtils.copyProperties(userEntity, userDomain);
		List<RoleEntity> userRoles=roleDao.queryUserByRole(id);
		for(RoleEntity entity:userRoles){
			RoleDomain doamin=new RoleDomain();
			BeanUtils.copyProperties(entity, doamin);
			roles.add(doamin);
		}
		userDomain.setRoles(roles);		
		return userDomain;
	}

	public List<UserEntity> findAllUser() {
		return userDao.findAllUser();
	}

	public UserEntity login(String username, String password) {
		UserEntity userEntity=new UserEntity();
		userEntity.setUsername(username);
		userEntity.setPassword(password);
		return userDao.login(userEntity);
	}

}
