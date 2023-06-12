package view;

import java.util.Scanner;

import authentication.context.authentication_context.events.GetUserEvent;
import catalogue.context.food_context.models.entity.Food;
import catalogue.context.shop_context.events.GetShopEvent;
import catalogue.context.shop_context.events.GoToShopCatalogueEvent;
import catalogue.context.shop_context.events.GoToShopDetailEvent;
import catalogue.context.shop_context.events.OnChosenShopEvent;
import utility.UtilityPage;

public class ShopDetailPage {
	private Scanner scan = new Scanner(System.in);
	public ShopDetailPage(String shopID) {
		int opt = -1;
		int count = 0;
		do {
			headerDisplay(shopID);
			count = foodDisplay(shopID);
			System.out.println("Choose food to buy:");
			System.out.println("Choose 0 to go back...");
			opt = UtilityPage.getOption(0, count);
			cartInput();
		}while(opt != 0);	
		GoToShopCatalogueEvent.run();
	}
	
	public void headerDisplay(String shopID) {
		System.out.println("==============================");
		System.out.printf("| %-26s |\n", GetShopEvent.run(shopID).getShopName());
		System.out.println("| Choose Your Favourite Menu |");
		System.out.println("==============================");
	}
	
	public int foodDisplay(String shopID) {
		int count = 0;
		for(Food f : OnChosenShopEvent.run(shopID)) {
			String currency = (f.getFoodPrice().getCurrency().equals("IDR"))? "Rp ":"$ ";
			System.out.println(" " + (count+1) + ". " + f.getFoodName());
			System.out.println("    " + currency + f.getFoodPrice().getValue());
			System.out.println("------------------------------");
			count++;
		}
		return count;
	}
	
	public void cartInput() {
		System.out.println("Choose quantity [Must be more than 0]:");
		int qty = scan.nextInt(); scan.nextLine();
		System.out.println("Write notes for shop:");
		String notes = scan.nextLine();
		//TODO: Connect to CartEvent
	}
}
