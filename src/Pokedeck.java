/**
 * Bibliothèque de cartes
 * permet d'ajouter , supprimer ou d'extraire une carte
 * affiche l'ensemble des cartes stockées dans la biobliothèque
 */
import java.io.Serializable;
import java.util.ArrayList;

public class Pokedeck implements Serializable {

	static protected final long serialVersionUID = 10L;
	private ArrayList<Card> deck = new ArrayList<Card>();

	public Pokedeck() {

	}
	
	public ArrayList<Card> listOfCards() {
		return deck;
	}

	public void addCard(Card c) {
		deck.add(c);
	}

	public void removeCard(Card c) {
		deck.remove(c);
	}

	public int getIndexCardByName(String name) {
		for (int i = 0; i < listOfCards().size(); i++) {
			if (deck.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
}
