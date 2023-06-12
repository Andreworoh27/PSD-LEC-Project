package catalogue.context.shop_context.models.entity;

import java.util.ArrayList;

import catalogue.context.food_context.models.entity.Food;

public class Shop {
	private String shopID;
	private String shopName;
	private String description;
	private ArrayList<Food> listOfFood;
	/**
	 * @param shopID
	 * @param shopName
	 * @param description
	 * @param listOfFood
	 */
	public Shop() {
		this.listOfFood = new ArrayList<Food>();
	}
	public String getShopID() {
		return shopID;
	}
	public void setShopID(String shopID) {
		this.shopID = shopID;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Food> getListOfFood() {
		return listOfFood;
	}
	public void setListOfFood(ArrayList<Food> listOfFood) {
		this.listOfFood = listOfFood;
	}
	public void addListOfFood(Food food) {
		this.listOfFood.add(food);
	}
}
