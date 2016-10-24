import java.util.ArrayList;

public class Order {
	private Client client;
	private ArrayList<Dish> dishes;
	private ArrayList<Beverage> beverages;
	
	public void setDish(ArrayList<Dish> dish) {
		this.dishes = dish;
	}

	public ArrayList<Dish> getDishes() {
		return dishes;
	}

	public void setBeverage(ArrayList<Beverage> beverages) {
		this.beverages = beverages;
	}
	
	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client c) {
		this.client = c;
	}
}
