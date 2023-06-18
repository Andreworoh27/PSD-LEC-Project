package food_ordering.context.transaction_context.models.entity;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import authentication.context.authentication_context.models.entity.User;
import catalogue.context.shop_context.models.entity.Shop;

public class TransactionHeader {
	private String transactionID;
	private User buyer;
	private Date transactionDate;
	private Date pickupDate;
	private ArrayList<TransactionDetail> transactionDetails;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * @param transactionID
	 * @param buyer
	 * @param seller
	 * @param transactionDetails
	 */
	public TransactionHeader(String transactionID, User buyer,Date transactionDate, Date pickupDate, ArrayList<TransactionDetail> transactionDetails) {
		super();
		this.transactionID = transactionID;
		this.buyer = buyer;
		this.transactionDate = transactionDate;
		this.pickupDate = pickupDate;
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

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public String getStringPickupDateFormat() {
		return dateFormat.format(pickupDate);
	}

	public String getStringTransactionDateFormat() {
		return dateFormat.format(transactionDate);
	}

	public ArrayList<TransactionDetail> getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(ArrayList<TransactionDetail> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

}
