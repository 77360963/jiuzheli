package www.yunpan.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.yunpan.com.db.IRoleDao;
import www.yunpan.com.entity.RoleEntity;
import www.yunpan.com.service.IRoleService;

@Service
public class IRoleServiceImpl implements IRoleService {
    
	@Autowired
	private IRoleDao roleDao;
	

	
	public void insertRole(RoleEntity role) {
		roleDao.insertRole(role);

	}

	public void updateRole(RoleEntity role) {
		roleDao.updateRole(role);

	}

	public void deleteRole(String id) {
	
		roleDao.deleteRole(id);

	}

	public RoleEntity findRoleById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<RoleEntity> fineAllRole() {
		// TODO Auto-generated method stub
		return null;
	}

}
