package com.home.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.home.model.SmsSendQueue;
@Repository
public interface SmsQueueRepo extends JpaRepository<SmsSendQueue, Long> {

}
