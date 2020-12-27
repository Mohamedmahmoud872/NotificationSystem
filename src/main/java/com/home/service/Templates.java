package com.home.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.model.NotificationTemplate;
import com.home.repo.INotifationTemplateDataAccessLayer;



@Service
public class Templates 
{
	@Autowired
	INotifationTemplateDataAccessLayer object;
	public List<NotificationTemplate>GetAllTemplates()
	{
		return object.findAll();
	}
	public void AddTemplate(NotificationTemplate obj)
	{
		object.save(obj);
	}
	public void UpdateTemplate(NotificationTemplate obj)
	{
		object.save(obj);
	}
	public void DeleteTemplate(Long id)
	{
		object.deleteById(id);
	}
	public Optional<NotificationTemplate> search(Long id )
	{
		return object.findById(id);
	}
}
