package com.protot.ECommerceb.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import com.protot.ECommerceb.homep.HomepController;
import com.protot.ECommerceb.homep.HomepService;
import com.protot.ECommerceb.models.ItemDetail;
import com.protot.ECommerceb.models.OrderAndCart;

import jakarta.servlet.http.HttpSession;

@Component
public class OrderAndCartService {

	
	@Autowired
	OrderAndCartDAO ocdao;

	@Autowired 
	HomepService hs;


	
	
	public OrderAndCart getuser(HttpSession session) {
		UUID i=(UUID)session.getAttribute("userid");
		return ocdao.getById(i);
	}
	
	
	public List<OrderAndCart> getorderandcart() {
		return ocdao.findAll();
	}
	
	
	public List<ItemDetail> getcart(HttpSession session) {
		UUID id=(UUID)session.getAttribute("userid");
		List<UUID> ucart=ocdao.getcart(id);
		
		List<ItemDetail> cart=new ArrayList<ItemDetail>();
		
		for(UUID i:ucart) {cart.add(hs.getoneitem(i));}
		
		return cart;
	}
	
	
	//login is used by user then we will call this method
	public void  creatcart(UUID Useri) {
		System.out.println(Useri);
		ocdao.createcart(Useri);
		System.out.println("Cart Created");
	}
	
	
	//To update an item cart or to add an item in cart
	public void insertitemcart(HttpSession session,UUID itemid ) {
		UUID useri=(UUID)session.getAttribute("userid");
		System.out.println(useri);
		System.out.println(itemid);
		System.out.println("Insertion using item id");
		ocdao.insertitemcart(useri,itemid);
	}
	

	
	public void deleteitemcart(HttpSession session,UUID itemid) {
		UUID useri=(UUID)session.getAttribute("userid");
		System.out.println("Deletion using itemid");
		ocdao.deleteitemcart(useri,itemid);
	}
	
	
	public List<ItemDetail> getorder(HttpSession session) {
		UUID useri=(UUID)session.getAttribute("userid");
		
		List<UUID> uorder=ocdao.getorder(useri);
			
		List<ItemDetail> order=new ArrayList<ItemDetail>();
			
			for(UUID i:uorder) {order.add(hs.getoneitem(i));}
			
			return order;
	}
	
	
	
	public void insertorder(HttpSession session,UUID itemid) {
		UUID useri=(UUID)session.getAttribute("userid");
		ocdao.insertorder(useri,itemid);
	}

	
	public void updateorderstatus(HttpSession session,UUID itemid) {
		
		UUID useri=(UUID)session.getAttribute("userid");
		UUID[] order=ocdao.getorderarra(useri);
		String[] orderstatusarra=ocdao.getorderstatusarr(useri);
		
		int j;j=0;
		for(UUID i:order) {
			if(i.equals(itemid)) {
				if(orderstatusarra[j].equals("Packaging")) {
					;orderstatusarra[j]="Delivered";
				}
			}j++;
		}
		
		ocdao.setorderstatuse(useri, order, orderstatusarra);
	}
	
	public List<String> getorderstatus(HttpSession session){
		UUID useri=(UUID)session.getAttribute("userid");
		return ocdao.getorderstatus(useri);
	}
	
	
	
	public List<Pair<UUID,String>> getorderandorderstatus(HttpSession session) {
		UUID useri=(UUID)session.getAttribute("userid");
		return ocdao.getorderandorderstatus(useri);
	}
	
	}
