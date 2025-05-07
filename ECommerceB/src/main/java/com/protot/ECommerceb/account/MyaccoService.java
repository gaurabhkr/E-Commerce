package com.protot.ECommerceb.account;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.protot.ECommerceb.homep.HomepController;
import com.protot.ECommerceb.login.LoginDAO;
import com.protot.ECommerceb.models.MyAcco;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import jakarta.websocket.Session;

@Component
public class MyaccoService {

     // find a user all info set default the previous one
	 // insert
	//deleton of an account 
	// username and password change 
	
	@Autowired
	MyaccoDAO accdao;
	
	@Autowired
	LoginDAO logdao;

	//To get an info 
	public MyAcco getuserinfor(UUID id)  {
		return accdao.getById(id);
	}
	
	//Deletion 
	public void deleteuser(UUID id) {
		accdao.deleteById(id);
	}
		
	
	
	//Update name
	//we are using this without use any query annotation
	public void updatename(HttpSession session,String name) {
		
		UUID id=(UUID)session.getAttribute("userid");
		
		MyAcco u=accdao.getById(id);
		
		u.setName(name);
		accdao.save(u);
		
		System.out.println(u.getName());

	}
	
	
	
	//Update contact
	public void updatecontact(HttpSession session,String contact) {
		UUID id=(UUID)session.getAttribute("userid");
		accdao.updatecontact(id,contact);
	}
	
	
	
	//Update address
	@Transactional
	public void updateaddress(HttpSession session,String address) {
		UUID id=(UUID) session.getAttribute("userid");
		accdao.Updateaddress(id,address);
	}
	
	
	
	//Update email
	@Transactional
	public void updateemail(HttpSession session,String email) {
		UUID id=(UUID) session.getAttribute("userid");
		accdao.updateemail(id,email);
	}
	
	
	
	//Update Username
	@Transactional
	public void updateusername(HttpSession session,String username) {
		UUID id=(UUID) session.getAttribute("userid");
		
		logdao.updateusername(id, username);
		
		session.removeAttribute("username");
		session.setAttribute("username",username);
	}
	
	//Update Password
	@Transactional
		public void updateuserpassword(HttpSession session,String password) {
			UUID id=(UUID) session.getAttribute("userid");
			
			logdao.updateuserpassword(id,password);
			
			session.removeAttribute("password");
			session.setAttribute("password",password);
		}
	
}
