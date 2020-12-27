package com.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.model.SmsSendQueue;
import com.home.repo.SmsQueueRepo;

@Service
public class SmsQueueService 
{
	@Autowired
	SmsQueueRepo queueServices;
	public List<SmsSendQueue>GetAllQueues()
	{
		return queueServices.findAll();
	}
	public void AddQueue(SmsSendQueue obj)
	{
		queueServices.save(obj);
	}
}
