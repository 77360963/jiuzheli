package www.yunpan.com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.yunpan.com.db.IPermissionDao;
import www.yunpan.com.db.IPermissionRoleDao;
import www.yunpan.com.db.IRoleDao;
import www.yunpan.com.domain.PermissionDomain;
import www.yunpan.com.domain.RoleDomain;
import www.yunpan.com.entity.PermissionEntity;
import www.yunpan.com.entity.PermissionRoleEntity;
import www.yunpan.com.entity.RoleEntity;
import www.yunpan.com.service.IRoleService;

@Service
public class IRoleServiceImpl implements IRoleService {
    
	@Autowired
	private IRoleDao roleDao;
	
	@Autowired
    private IPermissionDao permissionDao;
	
	@Autowired
	private IPermissionRoleDao permissionRoleDao;
	
	public void insertRole(RoleEntity role) {
		roleDao.insertRole(role);

	}

	public void updateRole(RoleEntity role,String[] permissionIds) {
		permissionRoleDao.deletePermissionRole(role.getId());
		roleDao.updateRole(role);
		if(null!=permissionIds){
			for(String permissionId:permissionIds){
				PermissionEntity permissionEntity=permissionDao.findPermissionById(permissionId);
				if(null!=permissionEntity){
					PermissionRoleEntity permissionRoleEntity=new PermissionRoleEntity();
					permissionRoleEntity.setRoleId(role.getId());
					permissionRoleEntity.setPermissionId(permissionEntity.getId());
					permissionRoleDao.insertPermissionRole(permissionRoleEntity);
				}
			}
		}		
		
	}

	public void deleteRole(String id) {
	
		roleDao.deleteRole(id);

	}

	public RoleDomain findRoleById(String id) {
		RoleEntity roleEntity= roleDao.findRoleById(id);
		List<PermissionEntity> permissionList=permissionDao.queryPermissionByRole(id);
		List<PermissionDomain> permissionDomainList=new ArrayList<PermissionDomain>();
		for(PermissionEntity entity:permissionList){
			PermissionDomain domain=new PermissionDomain();
			BeanUtils.copyProperties(entity, domain);
			permissionDomainList.add(domain);
		}
		RoleDomain roleDomain=new RoleDomain();
		BeanUtils.copyProperties(roleEntity, roleDomain);
		roleDomain.setPermissions(permissionDomainList);
		return roleDomain;
	}

	public List<RoleEntity> fineAllRole() {
		return roleDao.fineAllRole();
	}

}
