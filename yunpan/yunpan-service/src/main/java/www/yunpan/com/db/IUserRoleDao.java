package www.yunpan.com.db;

import www.yunpan.com.entity.UserRoleEntity;

public interface IUserRoleDao {
	
	  void insertUserRole(UserRoleEntity userRoleEntity); 
	    
	    
	   void deleteUserRole(String userId);

}
