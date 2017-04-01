package www.yunpan.com.domain;

import java.util.List;

public class UserDomain {
	

    private String id;

    private String username;

    private String password;
    
    private List<RoleDomain> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

	public List<RoleDomain> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDomain> roles) {
		this.roles = roles;
	}
    
    

}
