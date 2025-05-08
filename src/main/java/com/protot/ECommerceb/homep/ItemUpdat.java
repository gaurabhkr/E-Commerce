package com.protot.ECommerceb.homep;

import java.util.UUID;

import com.protot.ECommerceb.models.ItemDetail;

public class ItemUpdat {

	
	private ItemDetail item;
	private UUID itemi;
	private String name;
	private String price;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public ItemDetail getItem() {
		return item;
	}
	public void setItem(ItemDetail item) {
		this.item = item;
	}
	public UUID getItemi() {
		return itemi;
	}
	public void setItemi(UUID itemi) {
		this.itemi = itemi;
	}
	
	public void itemid() {
		this.item.setId(itemi);
	}
	
	public ItemUpdat() {}
//	Used in insert of item
	public ItemUpdat(ItemDetail item, UUID itemi) {
		super();
		this.item = item;
		this.itemi = itemi;
	}
	
	public ItemUpdat(ItemDetail item, UUID itemi, String name, String price) {
		super();
		this.item = item;
		this.itemi = itemi;
		this.name = name;
		this.price = price;
	}
	//Used in delete of item
	public ItemUpdat(String name, String price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	
	
}
