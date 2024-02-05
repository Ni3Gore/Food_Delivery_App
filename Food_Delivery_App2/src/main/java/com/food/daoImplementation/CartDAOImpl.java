package com.food.daoImplementation;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.food.model.CartItem;

public class CartDAOImpl {

	Map<Integer, CartItem> items;

	public CartDAOImpl() {

		items = new LinkedHashMap<Integer, CartItem>();
	}

	public void addItem(CartItem ci) {
		
		int itemid = ci.getItemid();
		int restid = ci.getRestid();
		if(items.containsKey(itemid)) {
			
			CartItem existingitem = items.get(itemid);
			existingitem.setQuantity(ci.getQuantity()+existingitem.getQuantity());					
		}
		else {
			items.put(ci.getItemid(), ci);
		}
	}

	public void updateItem(int itemId, int quantity) {

		if(items.containsKey(itemId)) {
			if(itemId<=0) {
				items.remove(itemId);
			}
			else {
				items.get(itemId).setQuantity(quantity);
			}
		}
	}

	public void removeItem(int itemId) {

		items.remove(itemId);
	}
	
	public Map<Integer, CartItem>  getAllItem() {
		
		
		return items;
	}
	
	public void clear() {

		items.clear();
	}
}
