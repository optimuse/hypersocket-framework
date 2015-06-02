package com.hypersocket.dashboard.message;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.hypersocket.resource.Resource;

@Entity
@Table(name="dashboard_messages")
public class DashboardMessage extends Resource {

	@Column(name="author")
	String author;
	
	@Column(name="body", length=8000)
	String body;

	@Column(name="name_resource_key")
	boolean nameResourceKey;
	
	@Column(name="body_resource_key")
	boolean bodyResourceKey;
	
	@Column(name="body_hyperlink")
	boolean bodyHyperlink;
	
	@Column(name="expires")
	@Temporal(TemporalType.TIMESTAMP)
	Date expires;
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public boolean isNameResourceKey() {
		return nameResourceKey;
	}

	public void setNameResourceKey(boolean nameResourceKey) {
		this.nameResourceKey = nameResourceKey;
	}

	public boolean isBodyResourceKey() {
		return bodyResourceKey;
	}

	public void setBodyResourceKey(boolean bodyResourceKey) {
		this.bodyResourceKey = bodyResourceKey;
	}

	public boolean isBodyHyperlink() {
		return bodyHyperlink;
	}

	public void setBodyHyperlink(boolean bodyHyperlink) {
		this.bodyHyperlink = bodyHyperlink;
	}

	public Date getExpires() {
		return expires;
	}

	public void setExpires(Date expires) {
		this.expires = expires;
	}

	
	
}
