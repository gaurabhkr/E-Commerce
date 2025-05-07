package com.protot.ECommerceb.account;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import com.protot.ECommerceb.homep.HomepController;
import com.protot.ECommerceb.homep.HomepDAO;
import com.protot.ECommerceb.login.LoginController;
import com.protot.ECommerceb.models.MyAcco;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping("account")
public class MyaccoContoller {
	
	@Autowired
	MyaccoService accser;

	@Autowired
	LoginController logincont;
	
	
	@RequestMapping("")
	//Any Unauthoriz access without login
	public String loginauthetication(HttpSession session) {
		
		if(((String)session.getAttribute("username"))==null) {return logincont.loginpage();}
		else {return accountpage(session);}

		}
	
	   @RequestMapping("accountpage")
	   public String accountpage(HttpSession session) {
		   return "Account";
	   } 
	   
	//Get Account Informat
	@GetMapping("/user")
	@ResponseBody
	public MyAcco getuserinf(HttpSession session) {
		System.out.println(accser.getuserinfor((UUID)session.getAttribute("userid")));
		return accser.getuserinfor((UUID)session.getAttribute("userid"));
	}
	
	
	//Delete Account 
	@DeleteMapping("/user")
	@ResponseBody
	public String deluser(HttpSession session) {
		accser.deleteuser((UUID)session.getAttribute("userid"));
		return "Update has been done";
	}
	
	
	//We are using this without use any query annotation
	@PostMapping("/user/name")
	@ResponseBody
	public String updatename(HttpSession session,@RequestParam("value") String name) {
		accser.updatename(session, name);
		System.out.println("Update has been done");
		return "Update has been done";
	}
	
	
	//Update Contact
	@Transactional
	@PostMapping("user/contact")
	@ResponseBody
	public String updatecontact(HttpSession session,@RequestParam("value")  String contact) {
		accser.updatecontact(session, contact);
		System.out.println("Update has been done");
		return "Update has been Done";
	}
	
	
	//Update Address
	@Transactional
	@PostMapping("user/address")
	@ResponseBody
	public String updateaddress(HttpSession session,@RequestParam("value") String address) {
		accser.updateaddress(session, address);
		System.out.println("Update has been done");
		return "Update has been Done";
	}
	
	
	
	//Update Email
	@Transactional
	@PostMapping("user/email")
	@ResponseBody
	public String updateemail(HttpSession session,@RequestParam("value")  String email) {
		accser.updateemail(session, email);
		System.out.println("Update has been done");
		return "Update has been Done";
	}
	
	
	
	//Update Username
	@Transactional
	@PostMapping("user/username")
	@ResponseBody
	public String updateusername(HttpSession session,@RequestParam("value")  String username) {
		accser.updateusername(session, username);
		System.out.println("Update has been done");
		return "Update has been Done";
	}
	
	
	//Update password
	@Transactional
	@PostMapping("user/password")
	@ResponseBody
	public String updatepassword(HttpSession session,@RequestParam("value")  String password) {
		accser.updateuserpassword(session, password);
		System.out.println("Update has been done");
		return "Update has been Done";
	}
	
	
	
}
