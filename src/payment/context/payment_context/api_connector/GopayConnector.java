package payment.context.payment_context.api_connector;

import java.util.Random;

public class GopayConnector implements APIConnectorInterface {
	public Random rand = new Random();
	private static GopayConnector instance;
	
	public static GopayConnector getInstance() {
		if(instance == null) {
			synchronized (GopayConnector.class) {
				if(instance == null) {
					instance = new GopayConnector();
				}
			}
		}
		return instance;
	}
	
	private GopayConnector() {
		
	}
	@Override
	public String getPaymentID() {
		String ID = "GPY-";
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
