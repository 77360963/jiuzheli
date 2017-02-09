package www.yunpan.com.domain;

import java.util.List;

//http://blog.csdn.net/driverking/article/details/6769553
public class RoleDomain {

    private String id;

    private String name;

    private String description;
    
    private List<PermissionDomain> permissions; 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	public List<PermissionDomain> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<PermissionDomain> permissions) {
		this.permissions = permissions;
	}
    
    

}
