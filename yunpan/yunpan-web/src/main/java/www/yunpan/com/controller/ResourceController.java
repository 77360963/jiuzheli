package www.yunpan.com.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import www.yunpan.com.domain.ResourceDomain;
import www.yunpan.com.entity.PermissionEntity;
import www.yunpan.com.entity.ResourceEntity;
import www.yunpan.com.form.ResourceForm;
import www.yunpan.com.service.IPermissionService;
import www.yunpan.com.service.IResourceService;

@Controller
public class ResourceController {
	
	@Autowired
	private IResourceService resourceService;
	
	@Autowired
	private IPermissionService permissionService;
	
	@RequestMapping(value="/addResource",method={RequestMethod.GET})
	public String addResource(final ModelMap model){
		List<PermissionEntity> permissionList=permissionService.findAllPermission();
		model.addAttribute("permissionList", permissionList);
		return "/view/addResource";
	}	
	
	@RequestMapping(value="/saveResource",method={RequestMethod.POST})
	public String saveResource(@ModelAttribute("resourceForm") ResourceForm form){
		ResourceEntity resource=new ResourceEntity();
		resource.setId(UUID.randomUUID().toString());
		resource.setUri(form.getUri());
		resource.setDescription(form.getDescription());
		resource.setPermissionId(form.getPermissionId());
		resourceService.insertResource(resource);		
		return "/view/index";
	}
	
	@RequestMapping(value="/delResource")	
	public String delResource(@RequestParam("id") String id){
		resourceService.deleteResource(id);			
		return "redirect:/queryAllResource.html";
	}
	
	@RequestMapping(value="/editResource")	
	public String editResource(final ModelMap model,@RequestParam("id") String id){
		ResourceDomain resource=resourceService.findResourceById(id);	
		List<PermissionEntity> permissionList=permissionService.findAllPermission();
		model.addAttribute("permissionList", permissionList);
		model.addAttribute("resource",resource);
		return "/view/editResource";
	}
	
	@RequestMapping(value="/updateResource")	
	public String updateResource(final ModelMap model,@ModelAttribute("resourceForm") ResourceForm form){
		ResourceEntity resource=new ResourceEntity();
		resource.setId(form.getId());
		resource.setUri(form.getUri());
		resource.setDescription(form.getDescription());
		resource.setPermissionId(form.getPermissionId());
		resourceService.updateResource(resource);
		return "redirect:/queryAllResource.html";
	}
	
	
	@RequestMapping(value="/queryAllResource")	
	public String queryAllResource(final ModelMap model){
		List<ResourceDomain> resourceList=resourceService.findAllResource();
		model.addAttribute("resourceList", resourceList);
		return "/view/resource";
	}

}
