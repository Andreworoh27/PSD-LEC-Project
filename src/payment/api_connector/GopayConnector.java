package payment.api_connector;

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
	public void pay() {
		System.out.print("Connecting to Gopay server");
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
