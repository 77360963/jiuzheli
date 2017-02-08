package www.yunpan.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import www.yunpan.com.annotation.Token;
import www.yunpan.com.service.FundCalendarService;

@Controller
public class UserController {
	
	@Autowired
	private FundCalendarService fundCalendarService;
	
	@RequestMapping(value="/welcome",method={RequestMethod.GET})
	@Token(remove=true)
	public String getUserList(){
		System.out.println("xxx");
		fundCalendarService.queryFundCalendar();
		return "/view/index";
	}
	
	@RequestMapping(value="/addUser",method={RequestMethod.GET})
	@Token(save=true)
	public String addUserIndex(){
		System.out.println("进入增加页面");		
		return "/view/addUser";
	}
	
	@RequestMapping(value="/saveUser",method={RequestMethod.POST})
	@Token(remove=true)
	public String saveUser(){
		System.out.println("保存完成");		
		return "/view/index";
	}

}
