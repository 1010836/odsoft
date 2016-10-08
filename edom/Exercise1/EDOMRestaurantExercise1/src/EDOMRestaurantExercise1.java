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
		System.out.println("Bem-vindo ao Super Restaurante, " + client.getName() + ".\n");
		System.out.println("Selecione o prato:\n");
		for (int i=0; i < dishes.size(); i++){
			System.out.println(i + " - " + dishes.get(i).getDenomination() + " - " + dishes.get(i).getCategory().getName());
		}
		System.out.println("\nIndique o número da sua escolha, pf: ");
		Scanner scan = new Scanner(System.in);
		String something;
		try {
			something= scan.nextLine();
		} finally {
			scan.close();
		}
		//System.out.println(something);
		/*for (int j = 0; j < dishes.size(); j++) {
			if (scan.nextInt() == j) {
				order.setDish(dishes.get(j));
			}
		}*/
		//System.out.println("O prato " + order.getDish().getDenomination() + " foi adicionado à sua ordem de compra.");
		
		// Prompts the list of beverages to user and waits for his choice
		/*System.out.println("Selecione a bebida:\n");
		for (int i=0; i < beverages.size(); i++){
			System.out.println(i + " - " + beverages.get(i).getDenomination() + " - " + beverages.get(i).getCategory().getName());
		}
		System.out.println("\nIndique o número da sua escolha, pf: ");
		Scanner scan2 = new Scanner(System.in);
		for (int j = 0; j < beverages.size(); j++) {
			String a = scan2.nextLine();
			int b = Integer.parseInt(a);
			if (b == j) {
				order.setBeverage(beverages.get(j));
			}
		}
		System.out.println(order.getBeverage().getDenomination() + " foi adicionado à sua ordem de compra.");
		*/
	}
}
