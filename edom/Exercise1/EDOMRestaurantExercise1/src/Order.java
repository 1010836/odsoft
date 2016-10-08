
public class Order {
	private int id;
	private Client client;
	private Dish dish;
	private Beverage beverage;

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public Beverage getBeverage() {
		return beverage;
	}

	public void setBeverage(Beverage beverage) {
		this.beverage = beverage;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client c) {
		this.client = c;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
