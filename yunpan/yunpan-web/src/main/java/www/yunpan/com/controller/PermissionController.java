package www.yunpan.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import www.yunpan.com.annotation.Token;
import www.yunpan.com.entity.PermissionEntity;
import www.yunpan.com.service.IPermissionService;

@Controller
public class PermissionController {/*
	
	@Autowired
	private IPermissionService permissionService;	
	
	@RequestMapping(value="/addPermission",method={RequestMethod.GET})
	@Token(save=true)
	public String addPermission(){			
		return "/view/addPermission";
	}
	
	@RequestMapping(value="/savePermission",method={RequestMethod.POST})
	@Token(remove=true)
	public String savePermission(){
		PermissionEntity permission=new PermissionEntity();
		permission.setId("1");
		permission.setName("资源管理");
		permission.setDescription("5454554545");
		permissionService.insertPermission(permission);		
		return "/view/index";
	}
	
	@RequestMapping(value="/delPermission")
	@Token(remove=true)
	public String delPermission(@RequestParam("id") String id){
		permissionService.deletePermission(id);			
		return "/view/index";
	}
	
	@RequestMapping(value="/queryAllPermission")
	public String queryAllPermission(final ModelMap model){
		List<PermissionEntity> permissionList=permissionService.findAllPermission();
		model.addAttribute("permissionList", permissionList);
		return "/view/permission";
	}

*/}
