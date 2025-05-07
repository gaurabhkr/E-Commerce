package com.protot.ECommerceb.login;

import java.util.UUID;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.protot.ECommerceb.account.MyaccoDAO;
import com.protot.ECommerceb.cart.OrderAndCartController;
import com.protot.ECommerceb.cart.OrderAndCartService;
import com.protot.ECommerceb.models.MyAcco;
import com.protot.ECommerceb.models.UserLogin;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

//All the business Logic will be write in service class
//We will make methods to call by controller

@Component
public class LoginService {
   @Autowired
	LoginDAO logindao;
   
   @Autowired 
   MyaccoDAO myaccdao;
   
   @Autowired
   OrderAndCartService  orderandcart;
   
   //to get user
   public UserLogin getuser(String name) {
	   return logindao.findByUsername(name);
   }
   
   
   //to create an user
   public RedirectView insertuser(String name,String password) {
	   System.out.println(logindao.findByUsername(name));
	   if(logindao.findByUsername(name)==null) {
		   UserLogin u=new UserLogin(name,password);
	    logindao.save(u);
	    UserLogin user=logindao.findByUsername(name); 
	    MyAcco l=new MyAcco(user.getId(),user.getUsername());
	    myaccdao.save(l);
	    orderandcart.creatcart(user.getId());
	    System.out.println("User registered");
	   }
	   else {
		   System.out.println("Already Registered");
	   }
	   return new RedirectView("/home");
   }
   
   
   //For Session attribute if user get login
   public void sessiononlogin(HttpSession session,String Username,String password,UUID i) {
	  session.setAttribute("username",Username);
	  session.setAttribute("password", password);
	  session.setAttribute("userid", i);
   }
   
   
   //Model is used to show data to pages only we will remove model 
   //For check of Login
	public RedirectView logincheck(HttpSession session,String name,String password,Model m) {
		
		String stat;
		

		if(logindao.findByUsername(name)==null) {
			
			System.out.println("Username and Password is not correct");
			//parameter to update jsp
			stat="Username and Password is not correct";
			m.addAttribute("resp",stat);
			return new RedirectView("/login");
			
		}else {
			String passw=logindao.findByUsername(name).getPassword();
			if(password.equals(logindao.findByUsername(name).getPassword())) {
				
				System.out.println("Username and Password is correct");	
				
				//we will use that attribut to check for backdo
			sessiononlogin(session,logindao.findByUsername(name).getUsername() ,logindao.findByUsername(name).getPassword() ,logindao.findByUsername(name).getId() );
				return new RedirectView("/home");
                
			}else {
				
				System.out.println("Password is not correct");
				//parameter to update jsp
				stat="Password is not correct";
				m.addAttribute("resp",stat);
				
				return new RedirectView("/login");
				//If we put in redirectview(home/homepage) the header will login/home/homepage it will add after prev header
				//If we put in redirectview(/home/homepage) the header will /home/homepage it will not add after prev header
			  
			}}
		
	}
	
	
	//For Logout 
	public void logoutses(HttpSession session) {
		if(session==null) {
			
		}else {
			session.removeAttribute("userid");
			session.removeAttribute("password");
			session.invalidate();
		}
	}
}
