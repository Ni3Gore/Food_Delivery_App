package com.food.model;

public class Menu {
	
	private int menuId;
	private int resturantId;
	private String itemName;
	private String discription;
	private double price;
	private boolean isAvailable;
	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(int menuId, int resturantId, String itemName, String discription, double price, boolean isAvailable) {
		super();
		this.menuId = menuId;
		this.resturantId = resturantId;
		this.itemName = itemName;
		this.discription = discription;
		this.price = price;
		this.isAvailable = isAvailable;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getResturantId() {
		return resturantId;
	}

	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "menu [menuId=" + menuId + ", resturantId=" + resturantId + ", itemName=" + itemName + ", discription="
				+ discription + ", price=" + price + ", isAvailable=" + isAvailable + "]";
	}
	
	
}
