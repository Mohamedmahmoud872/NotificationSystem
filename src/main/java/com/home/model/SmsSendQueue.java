package com.home.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="smsqueue")
public class SmsSendQueue 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	public String sender;
	public String receiver;
	public String Name;
	public String language;
	public String content;
	public Long getId() {
		return id;
	}
	public void setid(Long id) {
		this.id = id;
	}
	public String getsender() {
		return sender;
	}
	public void setsender(String sender) {
		this.sender = sender;
	}
	public String getreceiver() {
		return receiver;
	}
	public void setreceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name =Name;
	}
	public String getlanguage() {
		return language;
	}
	public void setlanguage(String language) {
		this.language = language;
	}
	public String getcontent() {
		return content;
	}
	public void setcontent(String content) {
		this.content = content;
	}
}
