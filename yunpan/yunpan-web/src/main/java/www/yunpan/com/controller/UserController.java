package www.yunpan.com.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import www.yunpan.com.entity.UserEntity;
import www.yunpan.com.form.UserForm;
import www.yunpan.com.service.IUserService;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;	
	
	@RequestMapping(value="/addUser",method={RequestMethod.GET})
	public String addUser(){			
		return "/view/addUser";
	}
	
	@RequestMapping(value="/saveUser",method={RequestMethod.POST})
	public String saveUser(@ModelAttribute("userForm") UserForm form){
		UserEntity user=new UserEntity();
		user.setId(UUID.randomUUID().toString());
		user.setUsername(form.getUsername());
		user.setPassword(form.getPassword());
		userService.insertUser(user);
		return "/view/index";
	}
	
	@RequestMapping(value="/queryAllUser",method={RequestMethod.POST})
	public String queryAllUser(@ModelAttribute("userForm") UserForm form){
		
		return "/view/user";
	}

}
