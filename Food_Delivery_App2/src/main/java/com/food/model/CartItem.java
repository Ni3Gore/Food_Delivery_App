package com.food.model;

public class CartItem {

	private int itemid;
	private int restid;
	private String itemname;
	private double price;
	private int quantity;

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItem(int itemid, int restid, String itemname, double price, int quantity) {
		super();
		this.itemid = itemid;
		this.restid = restid;
		this.itemname = itemname;
		this.price = price;
		this.quantity = quantity;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public int getRestid() {
		return restid;
	}

	public void setRestid(int restid) {
		this.restid = restid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItem [itemid=" + itemid + ", restid=" + restid + ", itemname=" + itemname + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}

}
