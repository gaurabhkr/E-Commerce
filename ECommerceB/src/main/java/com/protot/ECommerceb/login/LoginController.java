package com.protot.ECommerceb.login;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.protot.ECommerceb.homep.HomepService;
import com.protot.ECommerceb.models.UserLogin;

import jakarta.servlet.http.HttpSession;

//Controller is for calling methods
//We don't write any business logic in Controller class

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	LoginService ls;
	
	
	@ModelAttribute
	public void ruu() {
		System.out.println(">>>>Spring Application is Running<<<<");
	}
	
	@RequestMapping("/tes")
	public String tespage() {
		return "Product";
	}
	//To show login page not use in rest
   @RequestMapping("")
   public String loginpage() {
	   return "Loginpage";
   }
   
   //It will return register page not use in rest
   @GetMapping("/register")
   public String registerp() {
	   return "registeruser";
   }
   
   
   
//	Rest Methods 
   
   @PostMapping("/logincheck")
	   public RedirectView loginp(@RequestParam("username") String username,@RequestParam("password") String password,Model m,HttpSession session) {
	   System.out.println(username);
	   return ls.logincheck(session,username,password,m);
	   }
    
   //pass username and password 
   @PostMapping("/registeruser")
   public RedirectView chec(@RequestParam("registerusername") String username,@RequestParam("registerpassword") String password) {
	   System.out.println(username);
	  return ls.insertuser(username,password);
   }
   
   @RequestMapping("/logout")
   public RedirectView logout(HttpSession session) {
	   ls.logoutses(session);
	   //we are calling method if we call jsp then it will make heade issue
	   // we are calling method for call jsp page
	   return new RedirectView("/login");
   }
   
   @RequestMapping("/sessions")
   public void sess(HttpSession session) {
	   System.out.println(session.getAttribute("username"));
   }
   
}
