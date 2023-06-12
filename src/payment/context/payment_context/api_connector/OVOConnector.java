package payment.context.payment_context.api_connector;

import java.util.Random;

public class OVOConnector implements APIConnectorInterface {
	public Random rand = new Random();
	private static OVOConnector instance;
	
	public static OVOConnector getInstance() {
		if(instance == null) {
			synchronized (OVOConnector.class) {
				if(instance == null) {
					instance = new OVOConnector();
				}
			}
		}
		return instance;
	}
	
	private OVOConnector() {
		
	}
	@Override
	public String getPaymentID() {
		String ID = "OVO-";
		Integer temp = rand.nextInt(99999);
		ID += String.format("%5d", temp);
		return ID;
	}

	@Override
	public String pay(String paymentID) {
		
		return null;
	}

}
