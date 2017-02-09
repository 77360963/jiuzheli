package www.yunpan.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.yunpan.com.db.IPermissionDao;
import www.yunpan.com.db.IResourceDao;
import www.yunpan.com.entity.PermissionEntity;
import www.yunpan.com.service.IPermissionService;

@Service
public class IPermissionServiceImpl implements IPermissionService {
    
	@Autowired
	private IPermissionDao permissionDao;
	
	@Autowired
	private IResourceDao resourceDao;
	
	public void insertPermission(PermissionEntity permission) {
		permissionDao.insertPermission(permission);

	}

	public void deletePermission(String id) {
		resourceDao.updateResourcePermission(id);
		permissionDao.deletePermission(id);

	}

	public PermissionEntity findPermissionById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PermissionEntity> findAllPermission() {
		
		return permissionDao.findAllPermission();
	}

}
