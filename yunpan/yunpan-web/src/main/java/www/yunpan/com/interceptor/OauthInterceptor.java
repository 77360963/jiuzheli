package www.yunpan.com.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.ListUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import www.yunpan.com.domain.PermissionDomain;
import www.yunpan.com.domain.ResourceDomain;
import www.yunpan.com.domain.RoleDomain;
import www.yunpan.com.domain.UserDomain;
import www.yunpan.com.entity.UserEntity;
import www.yunpan.com.service.IResourceService;
import www.yunpan.com.service.IRoleService;
import www.yunpan.com.service.IUserService;

public class OauthInterceptor extends HandlerInterceptorAdapter {

	public final static String TOKEN_NAME = "token";
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IResourceService resourceService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		// 判断要访问的资源是否需要权限  
        String requestURI = request.getRequestURI(); 
        System.out.println("requestURI="+requestURI);
        ResourceDomain resourceDomain= resourceService.findResourceByURI(requestURI);
        PermissionDomain permissionDomain=resourceDomain.getPermission();
        if (null==permissionDomain) {            
            return true;  
        }  
        
        UserEntity user =(UserEntity)request.getSession().getAttribute("user"); 
     // 如果没有登录则跳转登录页面  
        if (null==user) {  
            request.getRequestDispatcher("/view/login.jsp").forward(request,response);  
            return false;  
        }  
        
        UserDomain userDomain= userService.findUserById(user.getId());        
        List<PermissionDomain> userPermission=new ArrayList<PermissionDomain>();       
        List<RoleDomain> roles=userDomain.getRoles();
        for(RoleDomain role:roles){        	
        	userPermission.addAll(roleService.findRoleById(role.getId()).getPermissions());
        }
        
        if(userPermission.contains(permissionDomain)){
        	 return true;  
        }else{
        	request.getRequestDispatcher("/error/invalidRequest").forward(request,response);
        }
     
		
		return super.preHandle(request, response, handler);

	}
	

}
