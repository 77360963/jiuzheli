package www.yunpan.com.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import www.yunpan.com.domain.UserDomain;
import www.yunpan.com.entity.RoleEntity;
import www.yunpan.com.entity.UserEntity;
import www.yunpan.com.form.UserForm;
import www.yunpan.com.service.IRoleService;
import www.yunpan.com.service.IUserService;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
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
	
	
	@RequestMapping(value="/queryAllUser",method={RequestMethod.GET})
	public String queryAllUser(final ModelMap model){
		 List<UserEntity> userList=userService.findAllUser();
		 model.addAttribute("userList", userList);
		return "/view/user";
	}
	
	@RequestMapping(value="/updateUser",method={RequestMethod.POST})
	public String updateUser(final ModelMap model,@ModelAttribute("userForm") UserForm form,HttpServletRequest request){
		String[] roleId = request.getParameterValues("rid");
		UserEntity userEntity=new UserEntity();
		userEntity.setId(form.getId());
		userEntity.setPassword(form.getPassword());		
		userService.updateUser(userEntity, roleId);
		return "redirect:/queryAllUser.html";
	}
	
	@RequestMapping(value="/delUser")	
	public String delResource(@RequestParam("id") String id){
		userService.deleteUser(id);	
		return "redirect:/queryAllUser.html";
	}
	
	
	@RequestMapping(value="/userRole",method={RequestMethod.GET})
	public String rolePermission(final ModelMap model,@RequestParam("id") String id){
		UserDomain user=userService.findUserById(id);
		List<RoleEntity> roleList=roleService.fineAllRole();
		model.addAttribute("user", user);
		model.addAttribute("roleList", roleList);
		return "/view/userRole";
	}

}
