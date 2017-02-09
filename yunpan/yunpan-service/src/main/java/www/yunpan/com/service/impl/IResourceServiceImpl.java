package www.yunpan.com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.yunpan.com.db.IPermissionDao;
import www.yunpan.com.db.IResourceDao;
import www.yunpan.com.domain.PermissionDomain;
import www.yunpan.com.domain.ResourceDomain;
import www.yunpan.com.entity.PermissionEntity;
import www.yunpan.com.entity.ResourceEntity;
import www.yunpan.com.service.IResourceService;

@Service
public class IResourceServiceImpl implements IResourceService {
	
	@Autowired
	private IResourceDao resourceDao;
	
	@Autowired
	private IPermissionDao permissionDao;

	public void insertResource(ResourceEntity resource) {
		resourceDao.insertResource(resource);

	}

	public void updateResource(ResourceEntity resource) {
		// TODO Auto-generated method stub

	}

	public List<ResourceDomain> findAllResource() {	
		List<ResourceDomain> ResourceDomainList=new ArrayList<ResourceDomain>();
		List<ResourceEntity> list= resourceDao.findAllResource();
		for(ResourceEntity entity:list){					
			PermissionEntity permissionEntity=permissionDao.findPermissionById(entity.getPermissionId());
			ResourceDomain resourceDomain=new ResourceDomain();			
			PermissionDomain permissionDomain=new PermissionDomain();
			BeanUtils.copyProperties(entity, resourceDomain);	
			BeanUtils.copyProperties(permissionEntity, permissionDomain);
			resourceDomain.setPermission(permissionDomain);
			ResourceDomainList.add(resourceDomain);
		}
		return ResourceDomainList;
	}

	public ResourceEntity findResourceByURI(String uri) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResourceEntity findResourceById(String id) {
		return resourceDao.findResourceById(id);
	}

	public void deleteResource(String id) {
		resourceDao.deleteResource(id);

	}

}
