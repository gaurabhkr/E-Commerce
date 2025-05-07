package com.protot.ECommerceb.models;

import java.util.Arrays;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table(name="orderandcart")
public class OrderAndCart {
	
	@Id
	@Column(name="id")
	private UUID id;
	
	@Column(name="cart" ,columnDefinition = "UUID[]")
	private UUID cart[];
	
	
	@Column(name="order",columnDefinition = "UUID[]")
	private UUID orders[];

	@Column(name="orderstatus",columnDefinition = "text[]")
	private String orderstatus[];

	
	public OrderAndCart(UUID id) {
		super();
		this.id = id;
	}

	
	
	@Override
	public String toString() {
		return "OrderAndCart [id=" + id + ", cart=" + Arrays.toString(cart) + ", orders=" + Arrays.toString(orders)
				+ ", orderstatus=" + Arrays.toString(orderstatus) + "]";
	}



	public UUID[] getCart() {
		return cart;
	}

	public void setCart(UUID[] cart) {
		this.cart = cart;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID[] getOrders() {
		return orders;
	}

	public void setOrders(UUID[] orders) {
		this.orders = orders;
	}

	public String[] getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String[] orderstatus) {
		this.orderstatus = orderstatus;
	}

	public OrderAndCart() {}
	
	public OrderAndCart(UUID id,UUID[] cart, UUID[] orders, String[] orderstatus) {
		super();
		this.cart = cart;
		this.id = id;
		this.orders = orders;
		this.orderstatus = orderstatus;
	}
	
	
	
	
}
