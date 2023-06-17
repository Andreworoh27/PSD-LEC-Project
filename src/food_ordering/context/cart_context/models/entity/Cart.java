package food_ordering.context.cart_context.models.entity;

import catalogue.context.food_context.models.entity.Food;

public class Cart {
    Food food;
    Integer quantity;
    String notes;

    public Cart(Food food, Integer quantity, String notes){
        this.food = food;
        this.quantity = quantity;
        this.notes = notes;
    }

    public Food getFood() {
        return food;
    }
    public String getNotes() {
        return notes;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setFood(Food food) {
        this.food = food;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
