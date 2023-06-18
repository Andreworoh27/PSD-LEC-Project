package view;

import java.util.ArrayList;
import java.util.Scanner;

import authentication.context.authentication_context.events.GetUserEvent;
import catalogue.context.food_context.events.OnGetFoodEvent;
import catalogue.context.food_context.models.entity.Food;
import catalogue.context.shop_context.events.GetShopEvent;
import catalogue.context.shop_context.events.GoToShopCatalogueEvent;
import catalogue.context.shop_context.events.GoToShopDetailEvent;
import catalogue.context.shop_context.events.OnChosenShopEvent;
import food_ordering.context.cart_context.events.AddToCart;
import food_ordering.context.cart_context.events.GoToCartEvent;
import utility.UtilityPage;

public class ShopDetailPage {
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Food> foodList = null;
	public ShopDetailPage(String shopID) {
		int opt = -1;
		int count = 0;
		UtilityPage.changePage();
		headerDisplay(shopID);
		count = foodDisplay(shopID);
		System.out.println("Choose food to buy:");
		System.out.println("Choose 0 to go back...");
		opt = UtilityPage.getOption(0, count);
		if(opt != 0) {
			cartInput(foodList.get(opt-1));
		}else if(opt == 0) {
			GoToShopCatalogueEvent.run();
		}
	}
	
	public void headerDisplay(String shopID) {
		System.out.println("==============================");
		System.out.printf("| %-26s |\n", GetShopEvent.run(shopID).getShopName());
		System.out.println("| Choose Your Favourite Menu |");
		System.out.println("==============================");
	}
	
	public int foodDisplay(String shopID) {
		int count = 0;
		foodList = OnChosenShopEvent.run(shopID);
		for(Food f : foodList) {
			String currency = (f.getFoodPrice().getCurrency().equals("IDR"))? "Rp ":"$ ";
			System.out.println(" " + (count+1) + ". " + f.getFoodName());
			System.out.println("    " + currency + f.getFoodPrice().getValue());
			System.out.println("------------------------------");
			count++;
		}
		return count;
	}
	
	public void cartInput(Food food) {
		System.out.print("Choose quantity: ");
		Integer qty = scan.nextInt(); scan.nextLine();
		System.out.print("Write notes for shop: ");
		String notes = scan.nextLine();
		AddToCart.addNewCart(food, qty, notes);
		GoToCartEvent.run();
	}
}
