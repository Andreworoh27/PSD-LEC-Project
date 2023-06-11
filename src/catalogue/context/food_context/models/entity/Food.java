package catalogue.context.food_context.models.entity;

import catalogue.context.food_context.models.value_object.Price;

public class Food {
	private String foodID;
	private String foodName;
	private Price foodPrice;
	private String shopID;
	public String getFoodID() {
		return foodID;
	}
	public void setFoodID(String foodID) {
		this.foodID = foodID;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public Price getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(Price foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getShopID() {
		return shopID;
	}
	public void setShopID(String shopID) {
		this.shopID = shopID;
	}
	/**
	 * @param foodID
	 * @param foodName
	 * @param foodPrice
	 */
	public Food() {
	}
	
}
