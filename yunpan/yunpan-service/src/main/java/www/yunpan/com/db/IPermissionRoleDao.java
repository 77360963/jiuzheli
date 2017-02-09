package www.yunpan.com.db;

import www.yunpan.com.entity.PermissionRoleEntity;

public interface IPermissionRoleDao {
	
	
    void insertPermissionRole(PermissionRoleEntity permissionRoleEntity); 
    
    
    void deletePermissionRole(String roleId);

}
