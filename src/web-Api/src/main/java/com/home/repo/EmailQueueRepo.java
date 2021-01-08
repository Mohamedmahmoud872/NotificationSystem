package com.home.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.model.EmailSendQueue;
@Repository
public interface EmailQueueRepo extends JpaRepository<EmailSendQueue, Long> {

}
