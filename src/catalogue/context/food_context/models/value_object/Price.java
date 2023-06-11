package catalogue.context.food_context.models.value_object;

public class Price {
	private String currency;
	private Double value;
	/**
	 * @param currency
	 * @param value
	 */
	public Price(String currency, Double value) {
		super();
		this.currency = currency;
		this.value = value;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Price changePrice(String currency, Double value) {
		return new Price(currency, value);
	}
	public Price convertToUSD() {
		if(this.currency.equals("IDR")) {
			return new Price("USD", 0.000067 * this.value);
		}
		return this;
	}
	public Price convertToIDR() {
		if(this.currency.equals("USD")) {
			return new Price("IDR", 14888.95 * this.value);
		}
		return this;
	}
}
