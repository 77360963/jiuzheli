package www.yunpan.com.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import www.yunpan.com.domain.RoleDomain;
import www.yunpan.com.entity.PermissionEntity;
import www.yunpan.com.entity.RoleEntity;
import www.yunpan.com.form.RoleForm;
import www.yunpan.com.service.IPermissionService;
import www.yunpan.com.service.IRoleService;

@Controller
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IPermissionService permissionService;
	
	@RequestMapping(value="/addRole",method={RequestMethod.GET})
	public String addRole(){			
		return "/view/addRole";
	}
	
	@RequestMapping(value="/saveRole",method={RequestMethod.POST})
	public String saveRole(@ModelAttribute("roleForm") RoleForm form){
		RoleEntity roleEntity=new RoleEntity();
		roleEntity.setId(UUID.randomUUID().toString());
		roleEntity.setName(form.getName());
		roleEntity.setDescription(form.getDescription());
		roleService.insertRole(roleEntity);
		return "/view/index";
	}
	
	@RequestMapping(value="/queryAllRole",method={RequestMethod.GET})
	public String queryAllRole(final ModelMap model){
		 List<RoleEntity> roleList=roleService.fineAllRole();
		 model.addAttribute("roleList", roleList);
		return "/view/role";
	}
	
	@RequestMapping(value="/updateRole",method={RequestMethod.POST})
	public String updateRole(final ModelMap model,@ModelAttribute("roleForm") RoleForm form,HttpServletRequest request){
		RoleEntity roleEntity=new RoleEntity();
		roleEntity.setId(form.getId());
		roleEntity.setName(form.getName());
		roleEntity.setDescription(form.getDescription());
		String[] permissionId = request.getParameterValues("pid");
		roleService.updateRole(roleEntity, permissionId);
		return "redirect:/queryAllRole.html";
	}
	
	
	@RequestMapping(value="/rolePermission",method={RequestMethod.GET})
	public String rolePermission(final ModelMap model,@RequestParam("id") String id){
		RoleDomain role=roleService.findRoleById(id);
		List<PermissionEntity> permissionList=permissionService.findAllPermission();
		model.addAttribute("permission", permissionList);
		model.addAttribute("role", role);
		return "/view/permissionRole";
	}

}
