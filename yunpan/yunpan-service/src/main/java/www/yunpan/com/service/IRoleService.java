package www.yunpan.com.service;

import java.util.List;

import www.yunpan.com.domain.RoleDomain;
import www.yunpan.com.entity.RoleEntity;

public interface IRoleService {
	
	// 新增角色  
    void insertRole(RoleEntity role);  
  
    // 更新角色  
    void updateRole(RoleEntity role,String[] permissionId); 
  
    // 删除角色  
    void deleteRole(String id);  
  
    // 根据id查找角色  
    RoleDomain findRoleById(String id);  
  
    // 查找所有角色  
    List<RoleEntity> fineAllRole();  

}
