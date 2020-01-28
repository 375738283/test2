package com.qh.im.api.vo;

import java.io.Serializable;

public class UserVo implements Serializable {

	private String name;
	private String accid;
	private String token;
	
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccid() {
		return accid;
	}
	public void setAccid(String accid) {
		this.accid = accid;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
