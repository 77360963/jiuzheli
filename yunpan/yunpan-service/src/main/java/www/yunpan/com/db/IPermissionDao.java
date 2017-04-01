package www.yunpan.com.db;

import java.util.List;

import www.yunpan.com.entity.PermissionEntity;

public interface IPermissionDao {
	
	// 插入新权限  
    void insertPermission(PermissionEntity permission);  
  
    // 删除权限  
    void deletePermission(String id);  
  
    // 根据id查找权限  
    PermissionEntity findPermissionById(String id);  
  
    // 查找所有权限  
    List<PermissionEntity> findAllPermission();  
    
    List<PermissionEntity> queryPermissionByRole(String roleId);

}
