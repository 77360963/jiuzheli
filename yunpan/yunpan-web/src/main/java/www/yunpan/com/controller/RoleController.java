package www.yunpan.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import www.yunpan.com.annotation.Token;
import www.yunpan.com.service.IRoleService;

@Controller
public class RoleController {
	
	@Autowired
	private IRoleService roleService;	
	
	@RequestMapping(value="/addRole",method={RequestMethod.GET})
	@Token(save=true)
	public String addRole(){			
		return "/view/addUser";
	}
	
	@RequestMapping(value="/saveRole",method={RequestMethod.POST})
	@Token(remove=true)
	public String saveRole(){
		
		return "/view/index";
	}

}
