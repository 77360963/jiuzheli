package www.yunpan.com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import www.yunpan.com.entity.UserEntity;
import www.yunpan.com.form.UserForm;
import www.yunpan.com.service.IUserService;

@Controller
public class IndexController {
	
	@Autowired
	private IUserService userService;
		
	
	@RequestMapping(value="/index",method={RequestMethod.GET})
	public String index(){			
		return "/view/index";
	}
	
	@RequestMapping(value="/login",method={RequestMethod.GET})
	public String loginIndex(){			
		return "/view/login";
	}
	
	@RequestMapping(value="/login",method={RequestMethod.POST})
	public String login(@ModelAttribute("userForm") UserForm form,HttpServletRequest request){	
		UserEntity user=userService.login(form.getUsername(), form.getPassword());
		if(null!=user){
			request.getSession().setAttribute("user", user);
			return "/view/index";
		}
		return "/view/login";
	}
	
	

}
