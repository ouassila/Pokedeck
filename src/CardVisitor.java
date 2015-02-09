/**
 * Permet de distinguer tous les types de cartes du programme (ici : Pokemon, TrainerCard et EnergyCard)
 * @author Ouassila
 *
 */
public abstract class CardVisitor {

	public abstract void visit(Pokemon p);

	public abstract void visit(TrainerCard t);

	public abstract void visit(EnergyCard e);
}
