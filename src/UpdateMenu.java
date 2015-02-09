/**
 * Permet de modifier une carte avec ses attributs qui lui sont propres
 */
import java.util.Scanner;

public class UpdateMenu extends CardVisitor {

	private Scanner sc = new Scanner(System.in);
	private int indexChange = 0;

	public void visit(Pokemon p) {

		String[] label = { "description", "name", "type", "HP", "stage", "number" };

		while (indexChange < 5) {
			System.out.println("If you want to update the pokemon's " + label[indexChange] + ", enter '" + ++indexChange + "' ");

		}
		indexChange = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter the new value :");
		String newValue = sc.nextLine();

		p.updateCard(this.indexChange, newValue);
	}

	public void visit(TrainerCard t) {
		String[] label = { "description", "name", "rule", "type" };

		while (indexChange < 4) {
			System.out.println("If you want to update the trainer card's"
					+ label[indexChange] + ", enter '" + ++indexChange + "' ");
		}
		indexChange = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter the new value :");
		String newValue = sc.nextLine();

		t.updateCard(this.indexChange, newValue);
	}

	// il n'y a que le nom qui peut etre mit à jour
	@Override
	public void visit(EnergyCard e) {

		System.out.print("Enter the new value :");
		String newValue = sc.nextLine();		
		e.updateCard(0, newValue);
	}

}
