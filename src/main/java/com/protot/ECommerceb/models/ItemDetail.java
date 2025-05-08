package com.protot.ECommerceb.models;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table(name="item")
public class ItemDetail {
@Id
//it will change uuid 
@GeneratedValue(strategy=GenerationType.UUID)
//UUID is an sequence of number
@Column(name="id")
private UUID id;

@Column(name="item_name")
private String name;

@Column(name="item_price")
private String price;

@Column(name="item_category")
private String category;

@Column(name="item_deliv")
private int deliverday;

@Column(name="item_seller")
private String seller;

@Column(name="item_about")
private String information;

@Column(name="item_images", columnDefinition = "text[]")
private String[] images;

public LocalDate deliverydate() {
	LocalDate x=LocalDate.now();
	return x.plusDays(this.deliverday);
}

public UUID getId() {
	return id;
}

public void setId(UUID id) {
	this.id = id;
}

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

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public int getDeliverday() {
	return deliverday;
}

public void setDeliverday(int deliverday) {
	this.deliverday = deliverday;
}

public String getSeller() {
	return seller;
}

public void setSeller(String seller) {
	this.seller = seller;
}

public String getInformation() {
	return information;
}

public void setInformation(String information) {
	this.information = information;
}

public String[] getImages() {
	return images;
}


public void setImages(String[] images) {
	this.images = images;
}

//This will use in inseritem
public ItemDetail( String name, String price, String category, int deliverday) {
	super();
	this.name = name;
	this.price = price;
	this.category = category;
	this.deliverday = deliverday;
}

//This will used in homeshowitem
public ItemDetail(UUID id, String name, String price, String category, int deliverday, String seller,
		String information, String[] images) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.category = category;
	this.deliverday = deliverday;
	this.seller = seller;
	this.information = information;
	this.images = images;
}

public ItemDetail(String name, String price, String category, int deliverday, String seller,
		String information, String[] images) {
	super();
	this.name = name;
	this.price = price;
	this.category = category;
	this.deliverday = deliverday;
	this.seller = seller;
	this.information = information;
	this.images = images;
}

//This will use in insertitem
public ItemDetail(UUID id, String name, String price, String category, int deliverday) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.category = category;
	this.deliverday = deliverday;
}

public ItemDetail() {}

@Override
public String toString() {
	return "ItemDetail [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", deliverday="
			+ deliverday + ", seller=" + seller + ", information=" + information + ", images=" + Arrays.toString(images)
			+ ", deliverdate="+deliverydate() + "]";
}


}
