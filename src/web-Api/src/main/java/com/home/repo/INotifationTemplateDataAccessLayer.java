package com.home.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.home.model.NotificationTemplate;

@Repository
public interface INotifationTemplateDataAccessLayer extends JpaRepository<NotificationTemplate, Long>
{

}
