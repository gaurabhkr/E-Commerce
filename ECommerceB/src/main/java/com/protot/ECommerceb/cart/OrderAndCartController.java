package com.protot.ECommerceb.cart;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import com.protot.ECommerceb.homep.HomepController;
import com.protot.ECommerceb.login.LoginController;
import com.protot.ECommerceb.models.ItemDetail;
import com.protot.ECommerceb.models.OrderAndCart;

import jakarta.servlet.http.HttpSession;


@RequestMapping("/user")
@Controller
public class OrderAndCartController {

	
	@Autowired
	OrderAndCartService ordcarser;

	@Autowired 
	LoginController logincont;
	
	@RequestMapping("")
	//Any Unauthoriz access without login
	public String loginauthetication(HttpSession session) {
		
		if(((String)session.getAttribute("username"))==null) {return logincont.loginpage();}
		else {return orderandcartpage(session);}

		}
		
	
	 @RequestMapping("ordercart")
	 public String orderandcartpage(HttpSession session) {
		   return "Order";
	 }
	
	//Set the userid 
	@GetMapping("userinf")
	@ResponseBody
	//Show User cart and order 
	public OrderAndCart userget( HttpSession session) {
		System.out.println(ordcarser.getuser(session));
		return ordcarser.getuser(session);
	}
	
	
	//Cart
	
	
	//Get list of Cart
	@GetMapping("/cart")
	@ResponseBody
	public List<ItemDetail> getcart(HttpSession session) {
		System.out.println(ordcarser.getcart(session));
		return ordcarser.getcart(session);
	}
		
	
	
	@PostMapping("/cart")
	@ResponseBody
	//To update or insert an item cart or to add an item in cart
	public String insertitemcart(HttpSession session,@RequestParam("value") UUID itemid) {
		System.out.println(itemid);
		ordcarser.insertitemcart(session, itemid);
		return "Item has been Inserted in Cart";
	}
	
	
	
	
	@DeleteMapping("/cart")
	@ResponseBody
	//Remove an Item in an Cart using item id
	public void deleteitemcart(HttpSession session,@RequestBody UUID itemid) {
		ordcarser.deleteitemcart(session, itemid);
		System.out.println("Delete of Cart");
	}
	
	
	//Order
	
	
	//Get list of orders
	@GetMapping("/order")
	@ResponseBody
	public List<ItemDetail> getorder(HttpSession session) {
		
		System.out.println(ordcarser.getorder(session));
		return ordcarser.getorder(session);
	}
	
	
	@PostMapping("/order")
	//Insert an order and orderstatus on Purchase 
	@ResponseBody
	public String insertorder(HttpSession session, @RequestParam("value") UUID itemid) {
		ordcarser.insertorder(session,itemid);
		System.out.println("Insert of order");
		return "Order had been done";
	}
	
	
	
	
	//OrderStatus
	
	//We will get list of an order and orderstatus then 
	//those are delivered will not update by using if statement in else we will update that orderstatus 
	
	
	//When user buys item it show packaging and we have to set it to delivered
	@PutMapping("/status")
	@ResponseBody
	public void updateorderstatus(HttpSession session,@RequestBody UUID itemid) {
	ordcarser.updateorderstatus(session,itemid);
	System.out.println("Update of Order");
	}
	
	@GetMapping("/status")
	@ResponseBody
	public List<String> getorderstatus(HttpSession session) {
		System.out.println(ordcarser.getorderstatus(session));
		return ordcarser.getorderstatus(session);
	}
	
	
	//Get Order and orderstatus list bug
	@GetMapping("/orderall")
	@ResponseBody
	public String getorderorderstatus(HttpSession session) {
		System.out.println(ordcarser.getorderandorderstatus(session));
		return "Not in Json";
	}
	
	
	
	
}
