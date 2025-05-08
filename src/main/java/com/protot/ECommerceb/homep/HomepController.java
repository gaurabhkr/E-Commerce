package com.protot.ECommerceb.homep;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.apache.catalina.manager.host.HostManagerServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.protot.ECommerceb.models.ItemDetail;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("home")
public class HomepController {
	
    @Autowired
	HomepService homser;

    
    @ModelAttribute
    public void chechom() {
    	System.out.println("HomepController is running");
    }

    @RequestMapping("")
    public String homep(HttpSession session,Model m) {
    	m.addAttribute("items",homser.getitem());
    	return "Homepag";
    }
    
    @RequestMapping("/about")
    public String aboutpage() {
    	return "Aboutus";
    }
    
    //To get all items 
    @GetMapping("/items")
    @ResponseBody
	public  List<ItemDetail> homepag() {
		System.out.println( homser.getitem());
		return homser.getitem();
		
	}
    
    
	//To Get any Item 
	@GetMapping("/item")
	@ResponseBody
	public ItemDetail getitempage(@RequestParam("value") UUID id) {
		System.out.println(homser.getoneitem(id));
		return homser.getoneitem(id);
	}
	
	
    //To Insert any item  
    //Two types of Response can be passed check itemdetail construc we can add images,seller,inform or not pass any seller,images,inform value
	@PostMapping("/item")
	@ResponseBody
	public String insertitem(@RequestBody ItemDetail u) {
		homser.insertitem(u);
		System.out.println("Insert has been done");
		return "Insert of an Item has been done";
	}

	
	//To update any Item using id 
	@PutMapping("/item")
	@ResponseBody
	public String updateitem(@RequestBody ItemUpdat u) {
		u.itemid();//To make no other id cannot be modified
		homser.updateitem(u.getItemi(),u.getItem());
		return "Update of Item has been done";
	}
	
	
	
	
	//To delete any Item
	@DeleteMapping("/item")
	@ResponseBody
	public String deleteitem(@RequestBody  UUID itemid) {
		homser.deleteitem(itemid);
		return "Deletion has been done";
	}
	
	
	
	//Insert Images to any Item
	@PostMapping("/item/{id}")
	@ResponseBody
	public String insertitemimage(@PathVariable("id") UUID itemid,@RequestBody String[] images) {
		homser.insertimage(itemid,images);
		return "Insertion of Images has been done";
	}
	
	
	
//	To get Delivery Date of Item
	@GetMapping("/itemdate")
	@ResponseBody
	public LocalDate itemdeliverydate(@RequestParam("value") UUID itemid) {
		System.out.println("Item Delivery Date");
	   return homser.itemdeliverydate(itemid);
	}
	
	
	//Used to Search Items  
	@GetMapping("/search")
	@ResponseBody
	public List<ItemDetail> searchsect(@RequestParam("value") String searchtext){
		System.out.println(homser.searchsect(searchtext));
		return homser.searchsect(searchtext);
	}
	
	
	//Used to Search by Category
	@GetMapping("/category")
	@ResponseBody
	public List<ItemDetail> categorysearch(@RequestParam("value") String category){
		System.out.println( homser.searchcatgory(category));
		return homser.searchcatgory(category);
	}
	
	
	
//	https://dadroit.com/string-to-json/ 
	
//	home/search and home/category --    anytext  			 (String)
//	home/itemdate 				  --  "UUID of Item"   		  (UUID)
//	home/item/{itemid}   		  -- [ "image1","image2"](Array of String) 
//	home/item(GET)and/item(DELETE)--   "UUID of Item"		  (UUID)
  
//	home/item(PUT)				  -- { "item":{"id":"" ,    it will not change the item id if we put any id we can add more seller,images
//    									"name": "Product 3","price": "200", "category": "Sports","deliverday": 3 }, 						(ItmeDetail)
//										"itemi":"ee7b454f-b066-40e0-9033-88b9f061e69b"}   UUID This id is used to search that object		(UUID)

//	home/item(POST)				  -- ItemDetail You can see items struc on home			(ItemDetail)					 								 
}
