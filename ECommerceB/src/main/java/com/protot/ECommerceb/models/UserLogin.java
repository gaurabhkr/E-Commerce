package com.protot.ECommerceb.models;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//We can use Lombok for not write the getter and setter ,we had to add dependenc of lombok
//@Data for getter and setter below entity and 
//If we don't want certain variable in @Data 
//we will use @Setter(AcessLevel.NONE) or @Getter(AcessLevel.NONE)
//@Id is for primary Key



@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table(name="user_login")
public class UserLogin {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
	
@Column(name="username", unique=true)
 private String username;
	
	@Column(name="password")
 private String password;

	public UserLogin() {}
	
	@Override
	public String toString() {
		return "UserLogin [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	public UserLogin(UUID id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public UserLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	

}
