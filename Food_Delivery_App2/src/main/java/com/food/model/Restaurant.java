package com.food.model;

public class Restaurant {

	private int restaurantId;
	private String name ;
	private String cuisine_type ;
	private int deliveryTime ;
	private String address ;
	private int adminUserId ;
	private float rating;
	private boolean isActive;
	private String imagePath;
	
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(int restaurantId, String name, String cuisine_type, int deliveryTime, String address,
			int adminUserId, float rating, boolean isActive, String imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.cuisine_type = cuisine_type;
		this.deliveryTime = deliveryTime;
		this.address = address;
		this.adminUserId = adminUserId;
		this.rating = rating;
		this.isActive = isActive;
		this.imagePath = imagePath;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuisine_type() {
		return cuisine_type;
	}

	public void setCuisine_type(String cuisine_type) {
		this.cuisine_type = cuisine_type;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAdminUserId() {
		return adminUserId;
	}

	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", cuisine_type=" + cuisine_type
				+ ", deliveryTime=" + deliveryTime + ", address=" + address + ", adminUserId=" + adminUserId
				+ ", rating=" + rating + ", isActive=" + isActive + ", imagePath=" + imagePath + "]";
	}
	
	
	
}
