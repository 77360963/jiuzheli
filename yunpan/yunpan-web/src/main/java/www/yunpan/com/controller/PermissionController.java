package www.yunpan.com.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import www.yunpan.com.annotation.Token;
import www.yunpan.com.entity.PermissionEntity;
import www.yunpan.com.form.PermissionForm;
import www.yunpan.com.service.IPermissionService;

@Controller
public class PermissionController {
	
	@Autowired
	private IPermissionService permissionService;	
	
	@RequestMapping(value="/addPermission",method={RequestMethod.GET})
	@Token(save=true)
	public String addPermission(){			
		return "/view/addPermission";
	}
	
	@RequestMapping(value="/savePermission",method={RequestMethod.POST})	
	public String savePermission(@ModelAttribute("permissionForm") PermissionForm form){
		PermissionEntity permission=new PermissionEntity();
		permission.setId(UUID.randomUUID().toString());
		permission.setName(form.getName());
		permission.setDescription(form.getDescription());
		permissionService.insertPermission(permission);		
		return "redirect:/queryAllPermission.html";
	}
	
	@RequestMapping(value="/delPermission")	
	public String delPermission(@RequestParam("id") String id){
		permissionService.deletePermission(id);			
		return "/view/permission";
	}
	
	@RequestMapping(value="/queryAllPermission",method={RequestMethod.GET})
	public String queryAllPermission(final ModelMap model){
		List<PermissionEntity> permissionList=permissionService.findAllPermission();
		model.addAttribute("permissionList", permissionList);
		return "/view/permission";
	}

}
