package com.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.model.EmailSendQueue;
import com.home.repo.EmailQueueRepo;
@Service
public class EmailQueueService 
{
	@Autowired
	EmailQueueRepo queueservice;
	public List<EmailSendQueue>GetAllQueues()
	{
		return queueservice.findAll();
	}
	public void AddQueue(EmailSendQueue obj)
	{
		queueservice.save(obj);
	}
	
}
