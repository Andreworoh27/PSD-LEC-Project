package payment.api_connector;

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
	public void pay() {
		System.out.print("Connecting to Dana server");
		for(int i =0; i<3; i++) {
			System.out.print(".");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
	}
	
	

}
