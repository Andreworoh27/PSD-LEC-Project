package payment.context.payment_context.api_connector;

import java.util.Random;

import catalogue.connector.FoodDatabaseManager;

public class DanaConnector implements APIConnectorInterface {
	public Random rand = new Random();
	private static DanaConnector instance;
	
	public static DanaConnector getInstance() {
		if(instance == null) {
			synchronized (DanaConnector.class) {
				if(instance == null) {
					instance = new DanaConnector();
				}
			}
		}
		return instance;
	}
	
	private DanaConnector() {
		
	}
	
	@Override
	public String getPaymentID() {
		String ID = "DAN-";
		Integer temp = rand.nextInt(99999);
		ID += String.format("%5d", temp);
		return ID;
	}

	@Override
	public String pay(String paymentID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
