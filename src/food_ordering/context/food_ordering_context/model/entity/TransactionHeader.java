package food_ordering.context.food_ordering_context.model.entity;

import java.util.ArrayList;

import authentication.context.authentication_context.models.entity.User;
import catalogue.context.shop_context.models.entity.Shop;

public class TransactionHeader {
	private String transactionID;
	private User buyer;
	private Shop seller;
	//TODO: Tambahin TransactionDateTime sama PickupDateTime Dru, gw gapaham TT
	private ArrayList<TransactionDetail> transactionDetails;
	
	/**
	 * @param transactionID
	 * @param buyer
	 * @param seller
	 * @param transactionDetails
	 */
	public TransactionHeader(String transactionID, User buyer, Shop seller,
			ArrayList<TransactionDetail> transactionDetails) {
		super();
		this.transactionID = transactionID;
		this.buyer = buyer;
		this.seller = seller;
		this.transactionDetails = transactionDetails;
	}
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public User getBuyer() {
		return buyer;
	}
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	public Shop getSeller() {
		return seller;
	}
	public void setSeller(Shop seller) {
		this.seller = seller;
	}
	public ArrayList<TransactionDetail> getTransactionDetails() {
		return transactionDetails;
	}
	public void setTransactionDetails(ArrayList<TransactionDetail> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
}
