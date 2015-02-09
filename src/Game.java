/**
 * Point d'entrée du programme 
 */
import java.io.IOException;

public class Game {

	public static void main(String[] args) throws ClassNotFoundException,
			IOException {

		Menu menu = new Menu();
		menu.globalMenuWithDataSerialize();

	}
}
