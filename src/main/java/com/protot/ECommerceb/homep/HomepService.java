package com.protot.ECommerceb.homep;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.protot.ECommerceb.models.ItemDetail;

import jakarta.transaction.Transactional;

@Component
public class HomepService {
	
	@Autowired
	HomepDAO hdao;
	
	
   //Insert Item
	public void insertitem(ItemDetail u) {
	   hdao.save(u);
   }
	
	//To get all Items
   public List<ItemDetail> getitem(){
	   List<ItemDetail> ite=hdao.findAll();
	   return ite;
   }
   
   
   //To get single item using an id can be used showing an item page
   @SuppressWarnings("deprecation")
public ItemDetail getoneitem(UUID id ) {
	   return hdao.getById(id);
   }
   
   //To delete an item used by admin to delete an item from homepage
   @Transactional
	public void deleteitem(UUID itemid) {
	hdao.deleteoneitem(itemid);
	}
   
   //To update an item using UUID id  we had to pass an itemdetail object other value make them null 
   public void updateitem(UUID id,ItemDetail u) {
	   u.setId(id);
	   hdao.save(u);
   }
   
   //To insert send String[] and uuid
   	@SuppressWarnings("deprecation")
   	public void insertimage(UUID id,String imageurl[]) {
	   ItemDetail u=hdao.getById(id);
	   u.setImages(imageurl);
	   hdao.save(u);
   	}
   	
   	
	public void insertimages(UUID id, String uploadedimage[]) {
		hdao.insertimage(id, uploadedimage);
   		
   	}

	@SuppressWarnings("deprecation")
	public LocalDate itemdeliverydate(UUID itemid) {
		ItemDetail u=hdao.getById(itemid);
		return u.deliverydate();
	}
	
	
   	public List<ItemDetail> searchsect(String searchtext) {
   			return hdao.searchsect(searchtext);
   		}
   	
   	public List<ItemDetail> searchcatgory(String category){
   		return hdao.searchcategory(category);
   	}

}