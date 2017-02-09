package www.yunpan.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import www.yunpan.com.annotation.Token;
import www.yunpan.com.entity.UserEntity;
import www.yunpan.com.service.IUserService;


public class UserController {
	
	/*@Autowired
	private IUserService userService;	
	
	@RequestMapping(value="/addUser",method={RequestMethod.GET})
	@Token(save=true)
	public String addUser(){			
		return "/view/addUser";
	}
	
	@RequestMapping(value="/saveUser",method={RequestMethod.POST})
	@Token(remove=true)
	public String saveUser(){
		UserEntity user=new UserEntity();
		user.setId("1");
		user.setUsername("gg");
		user.setPassword("1");
		userService.insertUser(user);
		return "/view/index";
	}
*/
}
