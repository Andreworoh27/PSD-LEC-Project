package payment.context.payment_context.api_connector;

public interface APIConnectorInterface {
	public abstract String getPaymentID();
	public abstract String pay(String paymentID);
}
