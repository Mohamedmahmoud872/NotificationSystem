package com.home.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.model.SmsSendQueue;
import com.home.service.SmsQueueService;

@RestController
@RequestMapping(value="/smsqueue")
public class SmsQueueController {
	@Autowired
	SmsQueueService queueService;
	@GetMapping("/get")
	public List<SmsSendQueue> getqueues(){
		return queueService.GetAllQueues();
	}
	@PostMapping("/ADD")
	public String AddQueu(@RequestBody SmsSendQueue temp)
	{
		queueService.AddQueue(temp);
		return "Added successfuly";
		
	}
}
