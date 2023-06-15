package food_ordering.context.food_ordering_context.model.entity;

import catalogue.context.food_context.models.entity.Food;

public class TransactionDetail {
	private Food food;
	private Integer quantity;
	private String notes;
	
	/**
	 * @param food
	 * @param quantity
	 * @param notes
	 */
	public TransactionDetail(Food food, Integer quantity, String notes) {
		super();
		this.food = food;
		this.quantity = quantity;
		this.notes = notes;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
