package payment.api_connector;

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
	public void pay() {
		System.out.print("Connecting to OVO server");
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
