package www.yunpan.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@RequestMapping(value="/welcome",method={RequestMethod.GET})
	public String getUserList(){
		System.out.println("xxx");
		return "/view/index";
	}

}
