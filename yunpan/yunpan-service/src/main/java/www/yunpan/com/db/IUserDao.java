package www.yunpan.com.db;

import java.util.List;

import www.yunpan.com.entity.UserEntity;

public interface IUserDao {
	
	// 插入用户  
    void insertUser(UserEntity user);  
  
    // 更新用户  
    void updateUser(UserEntity user);  
  
    // 删除用户  
    void deleteUser(String id);  
  
    // 根据id查找用户  
    UserEntity findUserById(String id);  
  
    // 查找所有用户  
    List<UserEntity> findAllUser();  
      
    //用户登录
    UserEntity login(UserEntity user);  
    
   

}
