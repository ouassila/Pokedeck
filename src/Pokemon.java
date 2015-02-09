/**
 * Type de cartes Pokemon, classe fille de Card
 * permet d'afficher, modifier, créer une carte pokemon
 * @author Ouassila
 *
 */
public class Pokemon extends Card {

	private static final long serialVersionUID = 10L;
	private String description, type;
	private int number, stage, HP;


	public Pokemon(String name, String description, String type, int number,
			int stage, int hp) {
		super(name);
		this.description = description;
		this.HP = hp;
		this.number = number;
		this.stage = stage;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + ", HP: " + this.HP + ", Number : "
				+ this.number + ", Stage : " + this.stage + ", Type : "
				+ this.type + ", Description : " + this.description;
	}

	@Override
	public void updateCard(int indexLabel, String value) {
		switch (indexLabel) {
		case 1:
			this.type = value;
			break;
		case 2:
			this.HP = Integer.parseInt(value);
			break;
		case 3:
			this.stage = Integer.parseInt(value);
			break;
		case 4:
			this.number = Integer.parseInt(value);
			break;
		case 5:
			this.description = value;
			break;
		case 6:
			this.name = value;
			break;
		}
	}

	@Override
	public void accept(CardVisitor v) {
		v.visit(this);
	}
}
