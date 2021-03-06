package www.yunpan.com.domain;

public class ResourceDomain {
    private String id;

    private String uri;

    private String description;

    private String permissionId;
    
    private PermissionDomain permission;
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

	public PermissionDomain getPermission() {
		return permission;
	}

	public void setPermission(PermissionDomain permission) {
		this.permission = permission;
	}
    
    
}