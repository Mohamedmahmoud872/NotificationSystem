package com.home.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home.model.NotificationTemplate;

import com.home.service.Templates;



@RestController
public class MemoryINotifationTemplateDataAccessLayer 
{
	@Autowired
	Templates  obj;
	@GetMapping("/find")
	public List<NotificationTemplate> getAllTemp(){
		return obj.GetAllTemplates();
	}
	@PostMapping("/add")
	public String AddTemp(@RequestBody NotificationTemplate temp)
	{
		obj.AddTemplate(temp);;
		return "Added successfuly";
		
	}
	@PutMapping("/update")
	public String UpdateTemp(@RequestBody NotificationTemplate temp)
	{
		obj.UpdateTemplate(temp);
		return "Update successfuly";
		
	}
	@DeleteMapping("/delete")
	public String DeleteTemp(@RequestParam Long id)
	{
		obj.DeleteTemplate(id);
		return "Delete successfuly";
		
	}
	@GetMapping("/search")
	public Optional<NotificationTemplate> GetTemplate(@RequestParam Long id ){
		return obj.search(id);
	}

}
 