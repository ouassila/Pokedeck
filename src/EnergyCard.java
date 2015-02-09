/**
 * fille de la classe Card
 * Correspond à un type de carte donné
 * @author Ouassila
 */
public class EnergyCard extends Card {

	private static final long serialVersionUID = 10L;

	
	public EnergyCard(String name) {
		super(name);
	}

	
	@Override
	public String toString() {
		return "Name : " + this.name;
	}

	@Override
	public void updateCard(int indexLabel, String value) {
		this.name = value;
	}

	@Override
	public void accept(CardVisitor v) {
		v.visit(this);
	}
}
