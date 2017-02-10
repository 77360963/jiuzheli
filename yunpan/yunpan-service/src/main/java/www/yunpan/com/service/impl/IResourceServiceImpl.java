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
		resourceDao.updateResource(resource);

	}

	public List<ResourceDomain> findAllResource() {	
		List<ResourceDomain> ResourceDomainList=new ArrayList<ResourceDomain>();
		List<ResourceEntity> list= resourceDao.findAllResource();
		for(ResourceEntity entity:list){					
			ResourceDomain resourceDomain=new ResourceDomain();	
			BeanUtils.copyProperties(entity, resourceDomain);	
			PermissionEntity permissionEntity=permissionDao.findPermissionById(entity.getPermissionId());
			if(null!=permissionEntity){
				PermissionDomain permissionDomain=new PermissionDomain();
				BeanUtils.copyProperties(permissionEntity, permissionDomain);
				resourceDomain.setPermission(permissionDomain);
			}			
			ResourceDomainList.add(resourceDomain);
		}
		return ResourceDomainList;
	}

	public ResourceDomain findResourceByURI(String uri) {
		ResourceDomain resourceDomain=new ResourceDomain();			
		ResourceEntity resourceEntity=resourceDao.findResourceByURI(uri);
		if(null!=resourceEntity){
			BeanUtils.copyProperties(resourceEntity, resourceDomain);			
			PermissionEntity permissionEntity=permissionDao.findPermissionById(resourceEntity.getPermissionId());
			PermissionDomain permissionDomain=new PermissionDomain();	
			BeanUtils.copyProperties(permissionEntity, permissionDomain);
			resourceDomain.setPermission(permissionDomain);
		}		
		return resourceDomain;
	}

	public ResourceDomain findResourceById(String id) {
		ResourceDomain resourceDomain=new ResourceDomain();	
		PermissionDomain permissionDomain=new PermissionDomain();	
		ResourceEntity resourceEntity= resourceDao.findResourceById(id);		
		PermissionEntity permissionEntity=permissionDao.findPermissionById(resourceEntity.getPermissionId());
		BeanUtils.copyProperties(resourceEntity, resourceDomain);
		BeanUtils.copyProperties(permissionEntity, permissionDomain);
		resourceDomain.setPermission(permissionDomain);
		return resourceDomain;
	}

	public void deleteResource(String id) {
		resourceDao.deleteResource(id);

	}

}
