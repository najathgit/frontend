package com.n.User.Model;

import javax.xml.bind.annotation.XmlRootElement;

import java.sql.Date;

import javax.xml.bind.annotation.*;
@XmlRootElement
public class User {
	
	private int id;
	private String first_name;
	private String last_name;
	private Date date_of_birth;
	private String telephone_no;
	private String username;
	private String password;
	private String email;
	private String user_type;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public Date getDate_of_birth() {
		return date_of_birth;
	}



	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}



	public String getTelephone_no() {
		return telephone_no;
	}



	public void setTelephone_no(String telephone_no) {
		this.telephone_no = telephone_no;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUser_type() {
		return user_type;
	}



	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}



	
	
	@Override
	public String toString() {
		
		return "User [id=" +id + " ,first_name=" + first_name + ", last_name=" + last_name + ", date_of_birth=" + date_of_birth
				+ ", telephone_no=" + telephone_no +", username=" + username + ",password="  + password + ",email="  +email +",password="+password+",user_type="+user_type +"]";
	}	
	
	
}	
	


