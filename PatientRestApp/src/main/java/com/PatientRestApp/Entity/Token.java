package com.PatientRestApp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tokentable")
public class Token {
 
	@Id
	@Column(name="Id")
	private int id;
	@Column(name="Token")
 	private String token;
	
	public Token(){
		
	}
 
	public int getId() {
		return id;
	}
	public Token(int id, String token) {
		super();
		this.id = id;
		this.token = token;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
