package com.protot.ECommerceb.models;

import java.util.Arrays;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY)
@Entity
@Table(name="user_account")
public class MyAcco {
	
@Id
@Column(name="id")
private UUID id;

@Column(name="name")
private String name;

@Column(name="address")
private String address;

@Column(name="email")
private String email;

@Column(name="contact")
private String contact;


//It will only create an object in register page where the login will genrate an uuid
//we will create an tabl with uuid;

public MyAcco() {}


public UUID getId() {
	return id;
}


public void setId(UUID id) {
	this.id = id;
}


public MyAcco(UUID id, String name, String address, String email, String contact) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
	this.email = email;
	this.contact = contact;
}


public MyAcco(UUID id, String name) {
	super();
	this.id = id;
	this.name = name;
}


public MyAcco(String name, String address, String email, String contact) {
	super();
	this.name = name;
	this.address = address;
	this.email = email;
	this.contact = contact;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getContact() {
	return contact;
}

public void setContact(String contact) {
	this.contact = contact;
}


@Override
public String toString() {
	return "MyAcco [name=" + name + ", address=" + address + ", email=" + email + ", contact=" + contact +"]";
}

}



