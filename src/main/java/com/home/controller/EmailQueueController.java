package com.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.home.model.EmailSendQueue;
import com.home.service.EmailQueueService;

@RestController
@RequestMapping(value="/emailqueue")
public class EmailQueueController 
{
	@Autowired
	EmailQueueService queueService;
	@GetMapping("/get")
	public List<EmailSendQueue> getqueues(){
		return queueService.GetAllQueues();
	}
	@PostMapping("/ADD")
	public String AddQueu(@RequestBody EmailSendQueue temp)
	{
		queueService.AddQueue(temp);
		return "Added successfuly";
		
	}
	
}
