import java.util.Scanner;

public class ArmySimulationMain {

	public void commandLineSimulation() {
		System.out.println("-------------------------------------");
		System.out.println("Command Line Simulation");
		System.out.println("-------------------------------------\n");

		// Gather user input
		Scanner sc = new Scanner(System.in);
		System.out.println("How many foot soldiers are in army 1?");
		int numFootSoldiers = sc.nextInt();

		System.out.println("How many tanks are in army 1?");
		int numTanks = sc.nextInt();

		System.out.println("How many planes are in army 1?");
		int numPlanes = sc.nextInt();

		Army army1 = new Army(numFootSoldiers, numTanks, numPlanes);

		System.out.println("How many foot soldiers are in army 2?");
		numFootSoldiers = sc.nextInt();

		System.out.println("How many tanks are in army 2?");
		numTanks = sc.nextInt();

		System.out.println("How many planes are in army 2?");
		numPlanes = sc.nextInt();

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


	}

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
