/**
 * Classe mère de tous les types de cartes (Pokemon , Trainer et Energy card )
 * liste toutes les actions possibles avec les cartes : afficher , modifier, ajouter
 */
import java.io.Serializable;

public abstract class Card implements Serializable {

	protected String name;
	static protected final long serialVersionUID = 10L;

	public Card(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract String toString();

	public abstract void updateCard(int indexLabel, String newValue);

	public abstract void accept(CardVisitor v);

}
