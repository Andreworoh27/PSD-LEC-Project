package view;

import catalogue.context.shop_context.events.GoToShopDetailEvent;
import catalogue.context.shop_context.events.OnLoadShopEvent;
import catalogue.context.shop_context.models.entity.Shop;
import utility.UtilityPage;

public class ShopCataloguePage {
	
	public ShopCataloguePage() {
		int opt = -1;
		do {
			System.out.println("----------------------------------");
			System.out.println("|Select shop from your canteen...|");
			System.out.println("----------------------------------");
			System.out.println();
			int count = shopDisplay();
			opt = UtilityPage.getOption(0, count);
			GoToShopDetailEvent.run(OnLoadShopEvent.run().get(opt - 1).getShopID());
		}while(opt!=0);
	}
	
	public int shopDisplay() {
		int count = 0;
		for(Shop shop : OnLoadShopEvent.run()) {
			System.out.println("" +(count+1) + ". " + shop.getShopName());
			System.out.println("    " + shop.getDescription());
			System.out.println();
			System.out.println("-----------------------------");
			System.out.println();			
			count++;
		}
		System.out.println("Type '0' to go back...");
		return count;
	}
}
