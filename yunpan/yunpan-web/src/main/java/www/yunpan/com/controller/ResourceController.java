package www.yunpan.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import www.yunpan.com.annotation.Token;
import www.yunpan.com.entity.ResourceEntity;
import www.yunpan.com.form.ResourceForm;
import www.yunpan.com.service.IResourceService;


public class ResourceController {/*
	
	@Autowired
	private IResourceService resourceService;	
	
	@RequestMapping(value="/addResource",method={RequestMethod.GET})
	@Token(save=true)
	public String addRole(){			
		return "/view/addResource";
	}
	
	@RequestMapping(value="/saveResource",method={RequestMethod.POST})
	@Token(remove=true)
	public String saveRole(@ModelAttribute("resourceForm") ResourceForm form){
		ResourceEntity resource=new ResourceEntity();
		resource.setId(form.getId());
		resource.setUri(form.getUri());
		resource.setPermissionId(form.getPermissionId());
		resourceService.insertResource(resource);		
		return "/view/index";
	}
	
	@RequestMapping(value="/queryAllResource")	
	public String queryAllResource(final ModelMap model){
		List<ResourceEntity> resourceList=resourceService.findAllResource();
		model.addAttribute("resourceList", resourceList);
		return "/view/index";
	}

*/}
