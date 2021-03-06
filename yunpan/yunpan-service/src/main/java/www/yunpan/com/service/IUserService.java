package www.yunpan.com.service;

import java.util.List;

import www.yunpan.com.domain.UserDomain;
import www.yunpan.com.entity.UserEntity;

public interface IUserService {
	
	// 插入用户  
    void insertUser(UserEntity user);  
  
    // 更新用户  
    void updateUser(UserEntity user,String[] roleId);  
  
    // 删除用户  
    void deleteUser(String id);  
  
    // 根据id查找用户  
    UserDomain findUserById(String id);  
  
    // 查找所有用户  
    List<UserEntity> findAllUser();  
      
    //用户登录
    UserEntity login(String username, String password);  
    
   

}
