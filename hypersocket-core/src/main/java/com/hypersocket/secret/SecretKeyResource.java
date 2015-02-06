package com.hypersocket.secret;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.hypersocket.resource.RealmResource;

@Entity
@Table(name="secret_keys")
public class SecretKeyResource extends RealmResource {

	@Column(name="keydata", length=8000)
	String keydata;
	
	@Column(name="iv", length=8000)
	String iv;
	
	public String getKeydata() {
		return keydata;
	}
	
	public void setKeydata(String keydata) {
		this.keydata = keydata;
	}
	
	public String getIv() {
		return iv;
	}
	
	public void setIv(String iv) {
		this.iv = iv;
	}

}