package www.yunpan.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.yunpan.com.db.IPermissionDao;
import www.yunpan.com.entity.PermissionEntity;
import www.yunpan.com.service.IPermissionService;

@Service
public class IPermissionServiceImpl implements IPermissionService {
    
	@Autowired
	private IPermissionDao permissionDao;
	
	public void insertPermission(PermissionEntity permission) {
		// TODO Auto-generated method stub

	}

	public void deletePermission(String id) {
		// TODO Auto-generated method stub

	}

	public PermissionEntity findPermissionById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PermissionEntity> findAllPermission() {
		// TODO Auto-generated method stub
		return null;
	}

}
