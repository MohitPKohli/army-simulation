import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class that controls both the command line simulation and visual simulation.
 * @author  Mohit Kohli
 * @version 1.0, May 2017
 */
public class ArmySimulationMain {

	/**
	 * Runs command line simulation
	 */
	public void commandLineSimulation() {
		System.out.println("-------------------------------------");
		System.out.println("Command Line Simulation");
		System.out.println("-------------------------------------\n");

		// Gather user input
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("How many foot soldiers are in army 1?");
			int numFootSoldiers = assertValidInput(sc.nextInt());

			System.out.println("How many tanks are in army 1?");
			int numTanks = assertValidInput(sc.nextInt());

			System.out.println("How many planes are in army 1?");
			int numPlanes = assertValidInput(sc.nextInt());

			Army army1 = new Army(numFootSoldiers, numTanks, numPlanes);

			System.out.println("How many foot soldiers are in army 2?");
			numFootSoldiers = assertValidInput(sc.nextInt());

			System.out.println("How many tanks are in army 2?");
			numTanks = assertValidInput(sc.nextInt());

			System.out.println("How many planes are in army 2?");
			numPlanes = assertValidInput(sc.nextInt());

			Army army2 = new Army(numFootSoldiers, numTanks, numPlanes);

			System.out.println("Simulating Battle");
			System.out.println("-------------------------------------");

			Battle battle = new Battle(army1, army2);
			int day = 1;
			System.out.println(battle + "\n");
			while (!battle.isFinished()) {
				battle.step();
				System.out.println(battle + "\n");
			}

			// Display Winner
			if (army1.isDefeated() && army2.isDefeated())
				System.out.println("The battle was a draw!");
			else if (army2.isDefeated())
				System.out.println("Army 1 is victorious!");
			else
				System.out.println("Army 2 is victorious!");
		} catch (InputMismatchException ex) {
			System.out.println("Army units must be entered as positive integers");
			return;
		}
	}

	private int assertValidInput(int in) {
		if (in < 0) {
			throw new InputMismatchException();
		}
		else {
			return in;
		}
	}

	/**
	 * Runs visual simulation.
	 */
	public void visualSimulation() {
		ArmySimulationFrame frame = new ArmySimulationFrame();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		ArmySimulationMain simulation = new ArmySimulationMain();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to army simulation by Mohit Kohli!");
		String mode = "";
		while (!(mode.equalsIgnoreCase("Y") || mode.equalsIgnoreCase("N"))) {
			System.out.println("Do you want to use visual mode? (Type Y or N)");
			mode = sc.next();
		}
		if(mode.equalsIgnoreCase("Y")) {
			simulation.visualSimulation();
		}
		else {
			simulation.commandLineSimulation();	
		}
	}
}
