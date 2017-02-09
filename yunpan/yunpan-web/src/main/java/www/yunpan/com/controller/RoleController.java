package www.yunpan.com.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import www.yunpan.com.entity.RoleEntity;
import www.yunpan.com.form.RoleForm;
import www.yunpan.com.service.IRoleService;

@Controller
public class RoleController {
	
	@Autowired
	private IRoleService roleService;	
	
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

}
