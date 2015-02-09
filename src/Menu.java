/**
 * Classe réservée à l'affichage:
 * 		affiche les menus et sous menus, inclue des contrôle de saisies
 * 		intermédiaire entre l'utilisateur et l'execution des fonctions dans le programme
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	private Scanner sc = new Scanner(System.in);
	private Pokedeck pokedeck = new Pokedeck();
	private DataSerialize datas = new DataSerialize("pokedeck.txt");
	private String name_card, action, actions_menu, actions_types;
	private ArrayList<String> possible_action = new ArrayList<String>();
	private ArrayList<String> possible_type = new ArrayList<String>();

	public Menu() {

	}

	public void start() {

		this.actions_menu = "* Enter 'C' to create a new card.\n"
				+ "* Enter 'V' to view the Pokedeck.\n"
				+ "* Enter 'R' to remove an existing card.\n"
				+ "* Enter 'E' to edit an existing card.\n"
				+ "* Enter 'Q' to quit the game.\n";

		possible_action.add("C");
		possible_action.add("V");
		possible_action.add("R");
		possible_action.add("E");
		possible_action.add("Q");

		this.actions_types = "* Enter 'P' if you want to create a new pokemon card.\n"
				+ "* Enter 'E' if you want to create a new energy card.\n"
				+ "* Enter 'T' if you want to create a new trainer card.\n";

		possible_type.add("P");
		possible_type.add("E");
		possible_type.add("T");
	}

	public void globalMenuWithDataSerialize() throws IOException,
			ClassNotFoundException {

		if (!datas.createAndOpen()) {
			if (datas.readFile()) {
				pokedeck = datas.readPokedeck();
				datas.closeIS();
			} else
				System.out.println("Aucun pokedeck n'est stocké.");
		} else
			System.out
					.println("Un fichier d'enregistrement de pokedeck a été créé.");

		this.start();
		this.globalMenu();

	}

	public void globalMenu() throws IOException {

		System.out.println(this.actions_menu);
		action = sc.nextLine().toUpperCase().trim();

		while (!action.isEmpty()) {

			if (this.possible_action.contains(action)) {
				switch (action.charAt(0)) {

				case 'E':
					System.out.print("Enter the card's name : ");
					name_card = sc.nextLine();
					this.menuUpdate(name_card.trim());
					break;

				case 'V':
					this.menuLookAtPokedeck();
					break;

				case 'Q':
					this.menuQuit();
					break;

				case 'C':
					this.menuCreateCard();
					break;

				case 'R':
					System.out.print("Enter the card's name : ");
					name_card = sc.nextLine();

					int index = pokedeck.getIndexCardByName(name_card.trim());
					this.menuRemove(index);

					break;
				}
			} else {
				System.out.println("Error : command not found");

			}
			System.out.println(this.actions_menu);
			action = sc.nextLine().toUpperCase().trim();
		}
	}

	public void menuCreateCard() {

		System.out.print("Name : ");
		name_card = sc.nextLine();

		if (pokedeck.getIndexCardByName(name_card) != -1) {
			System.out.println("The card is already exist.");
		} else {
			this.subMenuCreateCard(name_card);
		}
	}

	public void subMenuCreateCard(String name) {

		System.out.println(actions_types);
		String typeCard = sc.nextLine().toUpperCase().trim();
		int numberCard = 0, stage = 0, hp = 0;

		switch (typeCard.charAt(0)) {

		case 'P':

			System.out.print("Type : ");
			String typePokemon = sc.nextLine();

			System.out.print("HP : ");
			// controle de saisie supplémentaire pour la saisie exclusives des
			// int
			try {
				hp = sc.nextInt();
				sc.nextLine();

				System.out.print("Stage : ");
				stage = sc.nextInt();
				sc.nextLine();

				System.out.print("Number : ");

				numberCard = sc.nextInt();
				sc.nextLine();
			}

			catch (InputMismatchException e) {
				System.out.println("Error : The value must be an integer.");
				sc.nextLine();
				break;
			}

			System.out.print("Description : ");
			String descPokemon = sc.nextLine();

			Card card = new Pokemon(name, descPokemon, typePokemon, numberCard,
					stage, hp);
			pokedeck.addCard(card);

			break;

		case 'E':
			card = new EnergyCard(name);
			pokedeck.addCard(card);

			break;

		case 'T':
			System.out.print("Description : ");
			String description = sc.nextLine();

			System.out.print("Trainer Type : ");
			String trainerType = sc.nextLine();

			System.out.print("Rule  : ");
			String rule = sc.nextLine();

			System.out.print("Number : ");

			try {
				numberCard = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Error : The value must be an integer.");
				sc.nextLine();
				break;
			}

			card = new TrainerCard(description, trainerType, rule, name,
					numberCard);
			pokedeck.addCard(card);

			break;

		default:
			System.out.println("Error with type card.");
			break;
		}

	}

	public void menuLookAtPokedeck() {
		for (int i = 0; i < pokedeck.listOfCards().size(); i++) {
			System.out.println(pokedeck.listOfCards().get(i).toString());
		}
	}

	public void menuRemove(int index) {

		if (index != -1) {
			pokedeck.removeCard(pokedeck.listOfCards().get(index));
			System.out.println("Removed sucessful");
		} else
			System.out.println("Error : card not found.");

	}

	public void menuUpdate(String name) {

		int index = pokedeck.getIndexCardByName(name);

		if (index != -1) {
			Card card = pokedeck.listOfCards().get(index);

			card.accept(new UpdateMenu());
			card.toString();
		} else {
			System.out.println("Error : card not found");
		}
	}

	public void menuQuit() throws IOException {
		System.out.println("The end.");
		datas.writeFile(pokedeck);
		sc.close();
		System.exit(0);
	}

}
