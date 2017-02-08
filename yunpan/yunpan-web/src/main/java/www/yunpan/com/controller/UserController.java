package www.yunpan.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import www.yunpan.com.service.FundCalendarService;

@Controller
public class UserController {
	
	@Autowired
	private FundCalendarService fundCalendarService;
	
	@RequestMapping(value="/welcome",method={RequestMethod.GET})
	public String getUserList(){
		System.out.println("xxx");
		fundCalendarService.queryFundCalendar();
		return "/view/index";
	}

}
