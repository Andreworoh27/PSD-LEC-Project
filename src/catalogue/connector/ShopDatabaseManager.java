package catalogue.connector;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import catalogue.context.shop_context.controller.models.entity.Shop;
import catalogue.context.shop_context.controller.models.value_object.ShopController;

public class ShopDatabaseManager {
	private static ShopDatabaseManager instance = null;
	private static String filePath = "./src/database/shop.txt";
	
	public static ShopDatabaseManager getInstance() {
		if(instance == null) {
			synchronized (FoodDatabaseManager.class) {
				if(instance == null) {
					instance = new ShopDatabaseManager();
				}
			}
		}
		return instance;
	}
	
	private ShopDatabaseManager() {
		
	}
	
	public static ArrayList<Shop> getShopList() {
		ArrayList<Shop> shopList = new ArrayList<Shop>();
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line;
			while((line = br.readLine()) != null) {
				String[] value = line.split("#");
				Shop shop = ShopController.createShop(value[0], value[1], value[2]);
				shopList.add(shop);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not found!");
		} catch (IOException e) {
			System.out.println("File Not found!");
		}
		
		return shopList;
	}
}
