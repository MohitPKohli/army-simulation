import java.util.Scanner;

public class ArmySimulationMain {

	public void commandLineSimulation() {
		System.out.println("-------------------------------------");
		System.out.println("Command Line Simulation");
		System.out.println("-------------------------------------\n");

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

	}

	public void visualSimulation() {
		return;
	}

	public static void main(String[] args) {
		ArmySimulationMain simulation = new ArmySimulationMain();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to army simulation by Mohit Kohli!");
		System.out.println("Do you want to use visual mode? (Type Y or N)");
		String mode = sc.next();
		if(mode.equals("Y")) {
			simulation.visualSimulation();
		}
		else {
			simulation.commandLineSimulation();	
		}
	}
}
