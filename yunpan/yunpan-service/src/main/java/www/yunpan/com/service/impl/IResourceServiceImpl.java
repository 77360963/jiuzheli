package www.yunpan.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.yunpan.com.db.IResourceDao;
import www.yunpan.com.entity.ResourceEntity;
import www.yunpan.com.service.IResourceService;

@Service
public class IResourceServiceImpl implements IResourceService {
	
	@Autowired
	private IResourceDao resourceDao;

	public void insertResource(ResourceEntity resource) {
		resourceDao.insertResource(resource);

	}

	public void updateResource(ResourceEntity resource) {
		// TODO Auto-generated method stub

	}

	public List<ResourceEntity> findAllResource() {		
		return resourceDao.findAllResource();
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
