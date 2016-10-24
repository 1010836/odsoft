import java.util.ArrayList;
import java.util.Scanner;

public class EDOMRestaurantExercise1 {

	public static void main(String[] args) {
		// Assuming the client is registered and authenticated...
		Client client = new Client();
		client.setName("Nelson Lopes");
		
		Order order = new Order();
		order.setClient(client);
		
		// Load categories
		Category meat = new Category();
		meat.setName("Carne");
		Category fish = new Category();
		fish.setName("Peixe");	
		Category sGas = new Category();
		sGas.setName("Sem gás");
		Category cGas = new Category();
		cGas.setName("Com gás");
		
		// Load dishes
		ArrayList<Dish> dishes = new ArrayList<Dish>();
		Dish dish1 = new Dish();
		dish1.setDenomination("Francesinha");
		dish1.setCategory(meat);
		dishes.add(dish1);
		Dish dish2 = new Dish();
		dish2.setDenomination("Sardinha assada");
		dish2.setCategory(fish);
		dishes.add(dish2);
		
		// Load beverages
		ArrayList<Beverage> beverages = new ArrayList<Beverage>();
		Beverage beverage1 = new Beverage();
		beverage1.setDenomination("Água");
		beverage1.setCategory(sGas);
		beverages.add(beverage1);
		
		Beverage beverage2 = new Beverage();
		beverage2.setDenomination("Coca-cola");
		beverage2.setCategory(cGas);
		beverages.add(beverage2);
		
		// Prompts the list of dishes to user and waits for his choice
		ArrayList<Dish> orderDishes = new ArrayList<Dish>();
		ArrayList<Beverage> orderBeverages = new ArrayList<Beverage>();
		System.out.println("Bem-vindo ao Super Restaurante, " + client.getName() + ".\n");
		System.out.println("Selecione o prato:\n");
		for (int i = 0; i < dishes.size(); i++){
			System.out.println(i + " - " + dishes.get(i).getDenomination() + " - " + dishes.get(i).getCategory().getName());
		}
		System.out.println("\nIndique o número da sua escolha, pf: ");
		String scanString;
		int scanInt;
		Scanner scan = new Scanner(System.in);
		do {
			scanString = scan.nextLine();
			scanInt = Integer.parseInt(scanString);
			for (int j = 0; j < dishes.size(); j++) {
				if (scanInt == j) {
					orderDishes.add(dishes.get(j));
				}
			}
			if (scanInt != -1) { System.out.println("\nPrato adicionado à sua ordem de compra. Prima novamente uma opção para adicionar outro prato ou -1 para avançar.\n"); }
		} while (scanInt != -1);
		order.setDish(orderDishes);
		
		// Prompts the list of beverages to user and waits for his choice
		System.out.println("Selecione a bebida:\n");
		for (int i=0; i < beverages.size(); i++){
			System.out.println(i + " - " + beverages.get(i).getDenomination() + " - " + beverages.get(i).getCategory().getName());
		}
		System.out.println("\nIndique o número da sua escolha, pf: ");
		do {
			scanString = scan.nextLine();
			scanInt = Integer.parseInt(scanString);
			for (int k = 0; k < beverages.size(); k++) {
				if (scanInt == k) {
					orderBeverages.add(beverages.get(k));
				}
			}
			if (scanInt != -1) { System.out.println("\nBebida adicionada à sua ordem de compra. Prima novamente uma opção para adicionar outra bebida ou -1 para avançar."); }
		} while (scanInt != -1);
		order.setBeverage(orderBeverages);
		
		// Prints the order
		for (int p = 0; p < order.getDishes().size(); p++) {
			System.out.println(order.getDishes().get(p).getDenomination());
		}
		
		for (int m = 0; m < order.getDishes().size(); m++) {
			System.out.println(order.getBeverages().get(m).getDenomination());
		}
	}
}
