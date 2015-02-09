/**
 * Type de cartes d'entraineur, classe fille de Card
 * permet d'afficher, modifier, créer une carte d'entraineur
 * @author Ouassila
 *
 */
public class TrainerCard extends Card {

	
	private static final long serialVersionUID = 10L;
	private String description, type, rule;
	private int number;

	
	public TrainerCard(String d, String t, String r, String name, int number) {
		super(name);
		this.description = d;
		this.type = t;
		this.rule = r;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + ", Description: " + this.description
				+ ", Rule: " + this.rule + ", Type: " + this.type
				+ ", Number: " + this.number;
	}

	@Override
	public void updateCard(int indexLabel, String value) {

		switch (indexLabel) {
		case 1:
			this.description = value;
			break;
		case 2:
			this.name = value;
			break;
		case 3:
			this.rule = value;
			break;
		case 4:
			this.type = value;
			break;
		case 5:
			this.number = Integer.parseInt(value);
			break;
		}
	}

	@Override
	public void accept(CardVisitor v) {
		v.visit(this);
	}
}
