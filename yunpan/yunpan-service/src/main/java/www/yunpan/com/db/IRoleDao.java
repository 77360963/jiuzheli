package www.yunpan.com.db;

import java.util.List;

import www.yunpan.com.entity.RoleEntity;

public interface IRoleDao {
	
	// 新增角色  
    void insertRole(RoleEntity role);  
  
    // 更新角色  
    void updateRole(RoleEntity role);  
  
    // 删除角色  
    void deleteRole(String id);  
  
    // 根据id查找角色  
    RoleEntity findRoleById(String id);  
  
    // 查找所有角色  
    List<RoleEntity> fineAllRole();  

}
