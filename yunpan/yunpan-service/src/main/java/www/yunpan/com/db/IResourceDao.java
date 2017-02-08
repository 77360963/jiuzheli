package www.yunpan.com.db;

import java.util.List;

import www.yunpan.com.entity.ResourceEntity;

public interface IResourceDao {
	
	// 增加资源  
    void insertResource(ResourceEntity resource);  
  
    // 修改资源  
    void updateResource(ResourceEntity resource);  
  
    // 查找所有资源  
    List<ResourceEntity> findAllResource();  
  
    // 根据uri查找资源  
    ResourceEntity findResourceByURI(String uri);  
  
    // 根据id查找资源  
    ResourceEntity findResourceById(String id);  
  
    // 删除资源  
    void deleteResource(String id);  

}
