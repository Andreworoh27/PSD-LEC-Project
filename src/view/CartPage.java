package view;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import catalogue.context.food_context.models.value_object.Price;
import food_ordering.context.cart_context.events.CheckOutCart;
import food_ordering.context.cart_context.events.GetAllCart;
import food_ordering.context.cart_context.events.RemoveCart;
import food_ordering.context.cart_context.models.entity.Cart;
import food_ordering.context.transaction_context.events.OnSelectTransactionHeader;
import payment.context.payment_context.events.GoToPaymentPageEvent;
import utility.UtilityPage;

public class CartPage {
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Cart> cartList = null;
	Double totalPrice = 0.0;
	public CartPage() {
		int opt =0;
		do {
			UtilityPage.changePage();
			header();
			int count = cartDisplay();
			if(count != 0) {
				optionDisplay();
				opt = UtilityPage.getOption(1, 3);
				switch(opt) {
				case 1:
					String id = checkOut();
					GoToPaymentPageEvent.run(new Price("IDR", totalPrice), id);
					break;
				case 2:
					System.out.print("Select cart items number to be deleted:");
					int delOpt = UtilityPage.getOption(1, count);
					RemoveCart.removeCartByIndex(delOpt);
					break;
				}
			}else {
				System.out.println("No Cart list yet");
				UtilityPage.enterToContinue();
				break;
			}
		}while(opt != 1 && opt != 3);
	}
	
	public void header() {
		System.out.println("Cart Page");
		System.out.println("========================");
	}
	public int cartDisplay() {
		int count = 0;
		cartList = (ArrayList<Cart>) GetAllCart.getAllCarts();
		if(cartList.size() != 0) {
			System.out.println("| No | Food Name            | Food Price | Qty | Notes                                              | Subtotal |");
			for(Cart c : cartList) {
				Double subtotal = (c.getFood().getFoodPrice().getValue()) * (c.getQuantity());
				System.out.println("----------------------------------------------------------------------------------------------------------------");
				System.out.printf("| %-2d | %-20s | %-10.2f | %-3d | %-50s | %-8.2f |\n", count+1, c.getFood().getFoodName(), c.getFood().getFoodPrice().getValue(), c.getQuantity(), c.getNotes(), subtotal);
				totalPrice = totalPrice + subtotal;
				count++;
			}
			System.out.println("----------------------------------------------------------------------------------------------------------------");
			System.out.println("Total: " + totalPrice);
		}
		return count;
	}
	public void optionDisplay() {
		System.out.println("1. Checkout");
		System.out.println("2. Delete Cart");
		System.out.println("3. Back");
		System.out.println("Choose:");
	}
	
	public String checkOut() {
		System.out.print("Pickup Date [Format: 'yyyy-MM-dd HH:mm:dd']: ");
		String pickupDateString =  scan.nextLine();
		return CheckOutCart.checkOutCarts(pickupDateString, cartList);
	}
}
